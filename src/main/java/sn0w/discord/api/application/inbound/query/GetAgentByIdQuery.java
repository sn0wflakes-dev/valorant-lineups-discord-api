package sn0w.discord.api.application.inbound.query;

import sn0w.discord.api.core.domain.agent.AgentId;

public record GetAgentByIdQuery(
        AgentId agentId
) { }
