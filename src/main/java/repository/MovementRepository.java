package repository;

import model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovementRepository extends JpaRepository<Movement, String> {
    List<Movement> getAllMovementsByIban(String iban);
}



