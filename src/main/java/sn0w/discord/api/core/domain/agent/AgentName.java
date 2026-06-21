package sn0w.discord.api.core.domain.agent;

import java.util.Objects;
import java.util.regex.Pattern;

public class AgentName {

    private static final Pattern NAME_REGEXP = Pattern.compile("^[\\p{L} ]+$");

    private final String value;

    private AgentName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Agent name can't be null");
        }

        String trimmedValue = value.trim();

        if (!NAME_REGEXP.matcher(trimmedValue).matches()) {
            throw new IllegalArgumentException("Agent Name may only contain letters," +
                    " and spaces");
        }

        this.value = trimmedValue;
    }

    public static AgentName of(String value) {
        return new AgentName(value);
    }

    public AgentName changeName(String newValue) {
        return new AgentName(newValue);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AgentName{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AgentName agentName = (AgentName) o;
        return Objects.equals(value, agentName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
