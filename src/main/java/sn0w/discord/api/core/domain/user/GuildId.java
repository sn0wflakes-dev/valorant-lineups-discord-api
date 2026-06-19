package sn0w.discord.api.core.domain.user;

import java.util.UUID;

public class GuildId {
    private final String value;

    private GuildId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("GuildId id can't be null or empty");
        }

        this.value = value;
    }

    public static GuildId generate() {
        return new GuildId(UUID.randomUUID().toString());
    }

    public static GuildId of(String value) {
        return new GuildId(value);
    }

    public String getValue() {
        return value;
    }
}
