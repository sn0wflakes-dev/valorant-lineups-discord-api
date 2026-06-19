package sn0w.discord.api.adapter.outbound.database.mapper;

import sn0w.discord.api.adapter.outbound.database.jpa.entity.AgentEntity;
import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.domain.agent.AgentName;
import sn0w.discord.api.core.domain.agent.AgentType;
import sn0w.discord.api.core.domain.shared.Timestamp;

public class AgentRepositoryMapper {
    public static Agent toDomain(AgentEntity entity) {
        return Agent.builder()
                .agentId(AgentId.of(entity.getId()))
                .agentName(AgentName.of(entity.getName()))
                .agentType(AgentType.valueOf(entity.getAgentType().name()))
                .haveMolly(entity.getHaveMolly())
                .haveFlash(entity.getHaveFlash())
                .isActive(entity.getIsActive())
                .timestamp(Timestamp.of(entity.getCreatedAt(), entity.getUpdatedAt()))
                .build();
    }

    public static AgentEntity toEntity(Agent agent) {
        return AgentEntity.builder()
                .id(agent.getAgentId().getValue())
                .name(agent.getAgentName().getValue())
                .agentType(agent.getAgentType())
                .haveMolly(agent.getHaveMolly())
                .haveFlash(agent.getHaveFlash())
                .isActive(agent.getActive())
                .createdAt(agent.getTimestamp().getCreatedAt())
                .updatedAt(agent.getTimestamp().getUpdatedAt())
                .build();
    }
}
