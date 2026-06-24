package sn0w.discord.api.core.exception.agent;

import sn0w.discord.api.core.exception.DomainException;

public class AgentIdNotFound extends DomainException {

    private static final String CODE = "RESOURCE_NOT_FOUND";

    public AgentIdNotFound(String id) {
        super(CODE, String.format("Agent with id %s is not found", id));
    }
}
