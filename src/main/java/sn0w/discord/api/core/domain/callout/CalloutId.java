package sn0w.discord.api.core.domain.callout;

import java.util.UUID;

public class CalloutId {
    private final String value;

    private CalloutId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Callout id can't be null or empty");
        }

        this.value = value;
    }

    public static CalloutId generate() {
        return new CalloutId(UUID.randomUUID().toString());
    }

    public static CalloutId of(String value) {
        return new CalloutId(value);
    }

    public String getValue() {
        return value;
    }
}
