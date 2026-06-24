package sn0w.discord.api.application.inbound.usecase;

import sn0w.discord.api.application.inbound.command.AddAgentCommand;
import sn0w.discord.api.application.inbound.query.GetAgentByIdQuery;
import sn0w.discord.api.core.domain.agent.Agent;

public interface AgentUseCase {
    Agent addAgent(AddAgentCommand agent);
    Agent getAgentById(GetAgentByIdQuery agentId);
}
