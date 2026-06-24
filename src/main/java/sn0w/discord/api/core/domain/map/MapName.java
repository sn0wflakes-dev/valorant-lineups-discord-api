package sn0w.discord.api.core.domain.map;

import java.util.regex.Pattern;

public class MapName {
    private static final Pattern NAME_REGEXP = Pattern.compile("^[\\p{L} ]+$");

    private final String value;

    private MapName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Map name can't be null");
        }

        String trimmedValue = value.trim();

        if (!NAME_REGEXP.matcher(trimmedValue).matches()) {
            throw new IllegalArgumentException("Map Name may only contain letters," +
                    " and spaces");
        }

        this.value = trimmedValue;
    }

    public static MapName of(String value) {
        return new MapName(value);
    }

    public String getValue() {
        return value;
    }
}
