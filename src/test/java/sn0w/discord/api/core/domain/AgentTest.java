package sn0w.discord.api.core.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sn0w.discord.api.core.domain.agent.Agent;
import sn0w.discord.api.core.domain.agent.AgentId;
import sn0w.discord.api.core.domain.agent.AgentName;
import sn0w.discord.api.core.domain.agent.AgentType;

public class AgentTest {

    @Test
    public void agentOnSuccess() {
        Agent agent = Agent.builder()
                .agentId(AgentId.generate())
                .agentName(AgentName.of("Reyna"))
                .agentType(AgentType.DUELIST)
                .haveFlash(true)
                .haveMolly(false)
                .isActive(true)
                .build();

        Assertions.assertNotNull(agent.getAgentId().getValue());
        Assertions.assertNotNull(agent.getAgentName().getValue());
        Assertions.assertNotNull(agent.getAgentType());
        Assertions.assertNotNull(agent.getActive());
        Assertions.assertNotNull(agent.getHaveFlash());
    }

    // Exception

    @Test
    public void agentOnFailedWithNullAgentId() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Agent agent = Agent.builder()
                    .agentId(null)
                    .agentName(AgentName.of("Reyna"))
                    .agentType(AgentType.DUELIST)
                    .haveFlash(true)
                    .haveMolly(false)
                    .isActive(true)
                    .build();
        });

        Assertions.assertTrue(ex.getMessage().contains("null"));

    }

    @Test
    public void agentOnFailedWithNullAgentName() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Agent agent = Agent.builder()
                    .agentId(AgentId.generate())
                    .agentName(null)
                    .agentType(AgentType.DUELIST)
                    .haveFlash(true)
                    .haveMolly(false)
                    .isActive(true)
                    .build();
        });

        Assertions.assertTrue(ex.getMessage().contains("null"));

    }

    @Test
    public void agentOnFailedWithNullAgentType() {
        Exception ex = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Agent agent = Agent.builder()
                    .agentId(AgentId.generate())
                    .agentName(AgentName.of("Reyna"))
                    .agentType(null)
                    .haveFlash(true)
                    .haveMolly(false)
                    .isActive(true)
                    .build();
        });

        Assertions.assertTrue(ex.getMessage().contains("null"));

    }

    @Test
    public void agentOnFailedWithNullFlash() {
        Agent agent = Agent.builder()
                .agentId(AgentId.generate())
                .agentName(AgentName.of("Reyna"))
                .agentType(AgentType.DUELIST)
                .haveFlash(null)
                .haveMolly(false)
                .isActive(true)
                .build();

        Assertions.assertFalse(agent.getHaveFlash());

    }

    @Test
    public void agentOnFailedWithNullMolly() {
        Agent agent = Agent.builder()
                .agentId(AgentId.generate())
                .agentName(AgentName.of("Reyna"))
                .agentType(AgentType.DUELIST)
                .haveFlash(false)
                .haveMolly(null)
                .isActive(true)
                .build();

        Assertions.assertFalse(agent.getHaveMolly());

    }

    @Test
    public void agentOnFailedWithNullActive() {
        Agent agent = Agent.builder()
                .agentId(AgentId.generate())
                .agentName(AgentName.of("Reyna"))
                .agentType(AgentType.DUELIST)
                .haveFlash(true)
                .haveMolly(false)
                .isActive(null)
                .build();

        Assertions.assertTrue(agent.getActive());

    }
}
