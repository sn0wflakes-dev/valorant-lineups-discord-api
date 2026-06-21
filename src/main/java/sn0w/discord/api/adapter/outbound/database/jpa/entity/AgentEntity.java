package sn0w.discord.api.adapter.outbound.database.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sn0w.discord.api.core.domain.agent.AgentType;

import java.time.Instant;

@Table(name = "agent")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AgentEntity {

    @Id
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private AgentType agentType;

    @Column(name = "have_molly")
    private Boolean haveMolly;

    @Column(name = "have_flash")
    private Boolean haveFlash;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}
