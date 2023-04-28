package tn.devteam.immonexus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.devteam.immonexus.Entities.Dictionary;

public interface DictionnaryRepository extends JpaRepository<Dictionary, Long> {
}
