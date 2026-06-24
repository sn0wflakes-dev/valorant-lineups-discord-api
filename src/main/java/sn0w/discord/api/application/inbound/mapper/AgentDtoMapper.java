package sn0w.discord.api.application.inbound.mapper;

import sn0w.discord.api.application.inbound.command.AddAgentCommand;
import sn0w.discord.api.application.inbound.query.GetAgentByIdQuery;
import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;

public class AgentDtoMapper {

    public static Agent toDomain(AddAgentCommand command) {
        return Agent.builder()
                .agentId(command.agentId())
                .agentName(command.agentName())
                .agentType(command.agentType())
                .haveMolly(command.haveMolly())
                .haveFlash(command.haveFlash())
                .timestamp(command.timestamp())
                .build();
    }

    public static AgentId toAgentIdDomain(GetAgentByIdQuery query) {
        return AgentId.of(query.agentId().getValue());
    }
}
