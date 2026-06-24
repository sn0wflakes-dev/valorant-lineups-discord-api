package sn0w.discord.api.core.domain.map;

public class Map {
    private final MapId mapId;
    private final MapName mapName;
    private final Boolean isActive;

    public Map(Builder builder) {
        this.mapId = builder.mapId;
        this.mapName = builder.mapName;
        this.isActive = builder.isActive;
    }

    private static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private MapId mapId;
        private MapName mapName;
        private Boolean isActive;

        public Builder mapId(MapId mapId) {
            this.mapId = mapId;
            return this;
        }

        public Builder mapName(MapName mapName) {
            this.mapName = mapName;
            return this;
        }

        public Builder isActive(Boolean isActive) {
            this.isActive = isActive;
            return this;
        }

        public Map build() {
            if (mapId == null) throw new IllegalArgumentException("Map Id can't be null or empty");
            if (mapName == null) throw new IllegalArgumentException("Map Name can't be null or empty");
            if (isActive == null) this.isActive = true;
            return new Map(this);
        }

    }

    public MapId getMapId() {
        return mapId;
    }

    public MapName getMapName() {
        return mapName;
    }

    public Boolean getActive() {
        return isActive;
    }
}
