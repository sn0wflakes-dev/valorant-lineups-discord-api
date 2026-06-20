package sn0w.discord.api.adapter.inbound.rest.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sn0w.discord.api.adapter.inbound.rest.dto.WebResponse;
import sn0w.discord.api.adapter.inbound.rest.dto.request.AddAgentRequest;
import sn0w.discord.api.adapter.inbound.rest.dto.response.AddAgentResponse;
import sn0w.discord.api.adapter.inbound.rest.mapper.AgentDtoMapper;
import sn0w.discord.api.application.inbound.command.AddAgentCommand;
import sn0w.discord.api.application.inbound.service.ValidationService;
import sn0w.discord.api.application.inbound.usecase.AgentUseCase;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/agent")
public class AgentController {

    private static final Logger log = LogManager.getLogger(AgentController.class);

    private final AgentUseCase agentUseCase;
    private final ValidationService validationService;

    public AgentController(AgentUseCase agentUseCase, ValidationService validationService) {
        this.agentUseCase = agentUseCase;
        this.validationService = validationService;
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebResponse<AddAgentResponse>> addAgentController(
            @RequestBody AddAgentRequest request,
            HttpServletRequest httpRequest) {

        validationService.validate(request);

        String requestId = UUID.randomUUID().toString();

        log.info("Initiating request for adding agent with requestId : {}", requestId);

        AddAgentCommand command = AgentDtoMapper.toAddAgentCommand(request);
        AddAgentResponse response = AgentDtoMapper.toAddAgentResponse(agentUseCase.addAgent(command));

        WebResponse<AddAgentResponse> apiResponse = WebResponse.<AddAgentResponse>builder()
                .metadata(WebResponse.Metadata.builder()
                                .requestId(requestId)
                                .timestamp(Instant.now().toString())
                                .path(httpRequest.getRequestURI())
                                .build())
                .data(response)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(apiResponse);
    }

}
