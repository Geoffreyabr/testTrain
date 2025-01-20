package testTrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import testTrain.entity.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long> {
}
