package adhoc.repositories;

import adhoc.models.Abogade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbogadesRepository extends JpaRepository<Abogade, Long> {

}