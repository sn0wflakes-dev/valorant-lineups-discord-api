package sn0w.discord.api.core.domain.agent;

import sn0w.discord.api.core.domain.shared.Timestamp;

public class Agent {
    private final AgentId agentId;
    private final AgentName agentName;
    private final boolean haveMolly;
    private final boolean haveFlash;
    private final boolean isActive;
    private final AgentType agentType;
    private final Timestamp timestamp;

    private Agent(Builder builder) {
        this.agentId = builder.agentId;
        this.agentName = builder.agentName;
        this.haveMolly = builder.haveMolly;
        this.haveFlash = builder.haveFlash;
        this.isActive = builder.isActive;
        this.agentType = builder.agentType;
        this.timestamp = builder.timestamp;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder{
        private AgentId agentId;
        private AgentName agentName;
        private Boolean haveMolly;
        private Boolean haveFlash;
        private Boolean isActive;
        private AgentType agentType;
        private Timestamp timestamp;

        public Builder agentId(AgentId agentId) {
            this.agentId = agentId;
            return this;
        }

        public Builder agentName(AgentName name) {
            this.agentName = name;
            return this;
        }

        public Builder haveMolly(Boolean value) {
            this.haveMolly = value;
            return this;
        }

        public Builder haveFlash(Boolean value) {
            this.haveFlash = value;
            return this;
        }

        public Builder isActive(Boolean value) {
            this.isActive = value;
            return this;
        }

        public Builder agentType(AgentType agentType) {
            this.agentType = agentType;
            return this;
        }

        public Builder timestamp(Timestamp timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Agent build() {

            if (agentId == null) {
                throw new IllegalArgumentException("Agent Id can't be null");
            }

            if (agentName == null) {
                throw new IllegalArgumentException("Agent name can't be null");
            }

            if (agentType == null) {
                throw new IllegalArgumentException("Agent type can't be null");
            }

            if (haveMolly == null) {
                haveMolly = false;
            }

            if (haveFlash == null) {
                haveFlash = false;
            }

            if (isActive == null) {
                isActive = true;
            }

            return new Agent(this);
        }

    }

    public AgentId getAgentId() {
        return agentId;
    }

    public AgentName getAgentName() {
        return agentName;
    }

    public Boolean getHaveMolly() {
        return haveMolly;
    }

    public Boolean getHaveFlash() {
        return haveFlash;
    }

    public Boolean getActive() {
        return isActive;
    }

    public AgentType getAgentType() {
        return agentType;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
}
