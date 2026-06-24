package sn0w.discord.api.core.domain.callout;

import java.util.Objects;
import java.util.regex.Pattern;

public class CalloutName {
    private static final Pattern NAME_REGEXP = Pattern.compile("^[\\p{L} ]+$");

    private final String value;

    private CalloutName(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Callout name can't be null");
        }

        String trimmedValue = value.trim();

        if (!NAME_REGEXP.matcher(trimmedValue).matches()) {
            throw new IllegalArgumentException("Callout Name may only contain letters," +
                    " and spaces");
        }

        this.value = trimmedValue;
    }

    public static CalloutName of(String value) {
        return new CalloutName(value);
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "CalloutName{" +
                "value='" + value + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CalloutName calloutName = (CalloutName) o;
        return Objects.equals(value, calloutName.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
