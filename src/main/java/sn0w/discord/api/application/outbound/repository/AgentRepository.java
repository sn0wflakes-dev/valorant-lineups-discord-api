package sn0w.discord.api.application.outbound.repository;

import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.domain.agent.AgentName;
import sn0w.discord.api.core.domain.agent.AgentType;

import java.util.List;
import java.util.Optional;

public interface AgentRepository {
    Agent save(Agent agent);
    Optional<Agent> findById(AgentId agentId);
    Optional<Agent> findByName(AgentName agentName);
    Optional<List<Agent>> findByType(AgentType agentType);
    Optional<List<Agent>> getAll();
    Agent deleteAgentById(AgentId agentId);
    Agent updateAgentNameById(AgentId agentId);
}
