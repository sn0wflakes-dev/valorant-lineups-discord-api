package sn0w.discord.api.core.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sn0w.discord.api.core.domain.agent.AgentId;

public class AgentIdTest {

    @Test
    public void agentIdOnSuccess() {
        AgentId agentId = AgentId.generate();

        Assertions.assertNotNull(agentId.getValue());
    }

    @Test
    public void agentIdNotEqual() {
        AgentId agentIdOne = AgentId.generate();
        AgentId agentIdTwo = AgentId.generate();

        Assertions.assertNotEquals(agentIdOne, agentIdTwo);
    }

    @Test
    public void agentIdIsNull() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AgentId.of(null);
        });

        Assertions.assertTrue(ex.getMessage().contains("null"));
    }

}
