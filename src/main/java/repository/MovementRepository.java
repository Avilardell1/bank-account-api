package repository;

import model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovementRepository extends JpaRepository<Movement, String> {
    List<Movement> getAllMovementsByIban(String iban);
}



