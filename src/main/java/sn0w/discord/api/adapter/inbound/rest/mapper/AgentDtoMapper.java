package sn0w.discord.api.adapter.inbound.rest.mapper;

import sn0w.discord.api.adapter.inbound.rest.dto.request.AddAgentRequest;
import sn0w.discord.api.adapter.inbound.rest.dto.response.AddAgentResponse;
import sn0w.discord.api.adapter.inbound.rest.dto.response.GetAgentByIdResponse;
import sn0w.discord.api.application.inbound.command.AddAgentCommand;
import sn0w.discord.api.application.inbound.query.GetAgentByIdQuery;
import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.domain.agent.AgentName;
import sn0w.discord.api.core.domain.agent.AgentType;
import sn0w.discord.api.core.domain.shared.Timestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class AgentDtoMapper {

    public static AddAgentCommand toAddAgentCommand(AddAgentRequest dto) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dto.getCreatedAt(), formatter);
        Instant createdAt = localDate.atStartOfDay().toInstant(ZoneOffset.UTC);

        return new AddAgentCommand(
                AgentId.generate(),
                AgentName.of(dto.getName()),
                AgentType.valueOf(dto.getType()),
                dto.getHaveMolly(),
                dto.getHaveFlash(),
                Timestamp.of(createdAt, createdAt));
    }

    public static AddAgentResponse toAddAgentResponse(Agent agent){
        return AddAgentResponse.builder()
                .message("Add agent success")
                .id(agent.getAgentId().getValue())
                .name(agent.getAgentName().getValue())
                .build();
    }

    public static GetAgentByIdQuery toGetAgentByIdQuery(String agentId) {
        return new GetAgentByIdQuery(AgentId.of(agentId));
    }

    public static GetAgentByIdResponse toGetAgentByIdQuery(Agent agent) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy").withZone(ZoneId.systemDefault());

        return GetAgentByIdResponse.builder()
                .agentId(agent.getAgentId().getValue())
                .agentName(agent.getAgentName().getValue())
                .agentType(agent.getAgentType().name())
                .haveMolly(agent.getHaveMolly() ? "Yes" : "No")
                .haveFlash(agent.getHaveFlash() ? "Yes" : "No")
                .agentStatus(agent.getActive() ? "Active" : "In-Active")
                .creationDate(formatter.format(agent.getTimestamp().getCreatedAt()))
                .build();
    }
}
