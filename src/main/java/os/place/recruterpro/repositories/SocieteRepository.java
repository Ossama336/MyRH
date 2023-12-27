package os.place.recruterpro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import os.place.recruterpro.entities.Societe;

import java.util.Optional;

public interface SocieteRepository extends JpaRepository<Societe, Long> {
    Optional<Societe> findByEmail(String societe);
    Optional<Societe> findByCode(String code);

}
