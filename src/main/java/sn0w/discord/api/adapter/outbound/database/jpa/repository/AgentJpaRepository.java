package sn0w.discord.api.adapter.outbound.database.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn0w.discord.api.adapter.outbound.database.jpa.entity.AgentEntity;

import java.util.Optional;

@Repository
public interface AgentJpaRepository extends JpaRepository<AgentEntity, String> {
    Optional<AgentEntity> findByName(String agentName);
}
