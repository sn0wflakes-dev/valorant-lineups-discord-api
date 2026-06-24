package sn0w.discord.api.core.domain.map;

import java.util.UUID;

public class MapId {

    private final String value;

    private MapId(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Map id can't be null or empty");
        }

        this.value = value;
    }

    public static MapId generate() {
        return new MapId(UUID.randomUUID().toString());
    }

    public static MapId of(String value) {
        return new MapId(value);
    }

    public String getValue() {
        return value;
    }
}
