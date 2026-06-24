package sn0w.discord.api.core.domain.callout;

public class Callout {
    private final CalloutId calloutId;
    private final CalloutName calloutName;
    private final Boolean isActive;

    public Callout(Builder builder) {
        this.calloutId = builder.calloutId;
        this.calloutName = builder.calloutName;
        this.isActive = builder.isActive;
    }

    private static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private CalloutId calloutId;
        private CalloutName calloutName;
        private Boolean isActive;

        public Builder calloutId(CalloutId calloutId) {
            this.calloutId = calloutId;
            return this;
        }

        public Builder calloutName(CalloutName calloutName) {
            this.calloutName = calloutName;
            return this;
        }

        public Builder isActive(boolean isActive) {
            this.isActive = isActive;
            return this;
        }


        public Callout build() {
            if (calloutId == null) {
                throw new IllegalArgumentException("Callout Id can't be null or empty");
            }

            if (calloutName == null) {
                throw new IllegalArgumentException("Callout name can't be null or empty");
            }

            if (isActive == null) {
                isActive = true;
            }

            return new Callout(this);

        }

    }

    public CalloutId getCalloutId() {
        return calloutId;
    }

    public CalloutName getCalloutName() {
        return calloutName;
    }

    public Boolean getActive() {
        return isActive;
    }
}
