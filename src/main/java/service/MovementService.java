package service;

import model.Movement;
import java.util.List;

public interface MovementService {
    List<Movement> getMovements(String iban) throws Exception;
}
