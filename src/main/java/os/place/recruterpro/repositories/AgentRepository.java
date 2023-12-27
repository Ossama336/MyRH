package os.place.recruterpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import os.place.recruterpro.entities.Agent;

public interface AgentRepository extends JpaRepository<Agent, String> {

}
