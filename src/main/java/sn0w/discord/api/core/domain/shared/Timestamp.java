package sn0w.discord.api.core.domain.shared;

import java.time.Instant;

public class Timestamp {
    private final Instant createdAt;
    private final Instant updatedAt;

    public static Timestamp now() {
        Instant now = Instant.now();
        return new Timestamp(now, now);
    }

    public static Timestamp of(
            Instant createdAt,
            Instant updatedAt
    ){
        return new Timestamp(createdAt, updatedAt);
    }

    public Timestamp(Instant createdAt, Instant updatedAt) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }
}
