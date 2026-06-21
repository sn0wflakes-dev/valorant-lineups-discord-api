package sn0w.discord.api.core.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sn0w.discord.api.core.domain.agent.AgentName;

public class AgentNameTest {
    @Test
    public void agentNameOnSuccess() {
        AgentName agentName = AgentName.of("Cypher");

        Assertions.assertNotNull(agentName.getValue());
    }

    @Test
    public void agentNameOnChange() {
        AgentName agentName = AgentName.of("Reyna");
        AgentName renamedAgentName = agentName.changeName("Jett");

        Assertions.assertEquals("Jett", renamedAgentName.getValue());
    }


    // Exception test

    @Test
    public void agentNameIsNull() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AgentName.of(null);
        });

        Assertions.assertTrue(ex.getMessage().contains("null"));
    }

    @Test
    public void agentNameContainsProhibitedChar() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            AgentName.of("Cyph3r");
        });

        Assertions.assertTrue(ex.getMessage().contains("contain"));
    }
}
