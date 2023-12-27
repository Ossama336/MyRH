package os.place.recruterpro.repositories;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import os.place.recruterpro.entities.Postule;

public interface PostuleRepository extends JpaRepository<Postule, Long> {
}
