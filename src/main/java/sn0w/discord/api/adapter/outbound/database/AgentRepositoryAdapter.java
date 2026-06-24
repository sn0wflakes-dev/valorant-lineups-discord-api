package sn0w.discord.api.adapter.outbound.database;

import org.springframework.stereotype.Component;
import sn0w.discord.api.adapter.outbound.database.jpa.entity.AgentEntity;
import sn0w.discord.api.adapter.outbound.database.jpa.repository.AgentJpaRepository;
import sn0w.discord.api.adapter.outbound.database.mapper.AgentRepositoryMapper;
import sn0w.discord.api.application.outbound.repository.AgentRepository;
import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.domain.agent.AgentName;
import sn0w.discord.api.core.domain.agent.AgentType;

import java.util.List;
import java.util.Optional;

@Component
public class AgentRepositoryAdapter implements AgentRepository {

    private final AgentJpaRepository agentJpaRepository;

    public AgentRepositoryAdapter(AgentJpaRepository agentJpaRepository) {
        this.agentJpaRepository = agentJpaRepository;
    }

    @Override
    public Agent save(Agent agent) {
        AgentEntity entity = agentJpaRepository.save(AgentRepositoryMapper.toEntity(agent));
        return AgentRepositoryMapper.toDomain(entity);
    }

    @Override
    public Optional<Agent> findById(AgentId agentId) {
        return agentJpaRepository.findById(agentId.getValue()).map(AgentRepositoryMapper::toDomain);
    }

    @Override
    public Optional<Agent> findByName(AgentName agentName) {
        return agentJpaRepository.findByName(agentName.getValue()).map(AgentRepositoryMapper::toDomain);
    }

    @Override
    public Optional<List<Agent>> findByType(AgentType agentType) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Agent>> getAll() {
        return Optional.empty();
    }

    @Override
    public Agent deleteAgentById(AgentId agentId) {
        return null;
    }

    @Override
    public Agent deleteAgentByName(AgentName agentName) {
        return null;
    }

    @Override
    public Agent updateAgentNameById(AgentId agentId) {
        return null;
    }
}
