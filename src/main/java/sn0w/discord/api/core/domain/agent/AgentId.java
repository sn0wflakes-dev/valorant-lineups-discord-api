package sn0w.discord.api.core.domain.agent;

import java.util.UUID;

public class AgentId {

    private final String value;

    private AgentId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Agent id can't be null or empty");
        }

        this.value = value;
    }

    public static AgentId generate() {
        return new AgentId(UUID.randomUUID().toString());
    }

    public static AgentId of(String value) {
        return new AgentId(value);
    }

    public String getValue() {
        return value;
    }
}
