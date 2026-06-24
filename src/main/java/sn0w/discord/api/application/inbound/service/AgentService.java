package sn0w.discord.api.application.inbound.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import sn0w.discord.api.application.inbound.command.AddAgentCommand;
import sn0w.discord.api.application.inbound.mapper.AgentDtoMapper;
import sn0w.discord.api.application.inbound.query.GetAgentByIdQuery;
import sn0w.discord.api.application.inbound.usecase.AgentUseCase;
import sn0w.discord.api.application.outbound.repository.AgentRepository;
import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.exception.agent.AgentIdNotFound;
import sn0w.discord.api.core.exception.agent.AgentNameAlreadyExist;

@Service
public class AgentService implements AgentUseCase {

    private static final Logger log = LogManager.getLogger(AgentService.class);

    private final AgentRepository agentRepository;

    public AgentService(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public Agent addAgent(AddAgentCommand agent) {
        try {

            Agent data = AgentDtoMapper.toDomain(agent);

            agentRepository.findByName(data.getAgentName()).ifPresent(
                    entity -> {
                        throw new AgentNameAlreadyExist("Agent name is already exist");
                    }
            );

            log.info("Agent {} with id {} added successfully",
                    agent.agentName().getValue(),
                    agent.agentId().getValue());

            return agentRepository.save(data);
        } catch (Exception e) {
            log.error("Add agent failed, error : {}",
                    e.getMessage());

            throw e;
        }
    }

    @Override
    public Agent getAgentById(GetAgentByIdQuery agentId) {

        try {

            AgentId id = AgentDtoMapper.toAgentIdDomain(agentId);

            Agent agent = agentRepository.findById(id).orElseThrow(
                    () -> new AgentIdNotFound(id.getValue())
            );

            log.info("Agent {} with id {} successfully fetched",
                    agent.getAgentName().getValue(),
                    agent.getAgentId().getValue());

            return agent;

        } catch (Exception e) {
            log.error("Failed to fetch agent with id {}, error : {}",
                    agentId.agentId().getValue(),
                    e.getMessage());
            throw e;
        }
    }

}
