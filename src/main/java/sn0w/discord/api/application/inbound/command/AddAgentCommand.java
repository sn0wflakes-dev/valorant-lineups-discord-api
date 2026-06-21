package sn0w.discord.api.application.inbound.command;

import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.domain.agent.AgentName;
import sn0w.discord.api.core.domain.agent.AgentType;
import sn0w.discord.api.core.domain.shared.Timestamp;

public record AddAgentCommand(
        AgentId agentId,
        AgentName agentName,
        AgentType agentType,
        Boolean haveMolly,
        Boolean haveFlash,
        Timestamp timestamp
) {}
