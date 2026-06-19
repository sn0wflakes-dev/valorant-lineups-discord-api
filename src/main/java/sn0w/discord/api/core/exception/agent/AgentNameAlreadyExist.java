package sn0w.discord.api.core.exception.agent;

import sn0w.discord.api.core.exception.DomainException;

public class AgentNameAlreadyExist extends DomainException {

    private final static String CODE = "RESOURCE_ALREADY_EXIST";

    public AgentNameAlreadyExist(String message) {
        super(CODE, message);
    }
}
