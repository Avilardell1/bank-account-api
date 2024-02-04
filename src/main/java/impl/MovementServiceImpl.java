package impl;

import common.CheckDigitException;
import common.Common;
import lombok.NoArgsConstructor;
import model.Movement;
import org.springframework.stereotype.Service;
import repository.MovementRepository;
import service.MovementService;
import java.util.ArrayList;
import java.util.List;

@Service
@NoArgsConstructor
public class MovementServiceImpl implements MovementService {

    private MovementRepository movementRepository;

    public MovementServiceImpl (MovementRepository movementRepository) {
        this.movementRepository = movementRepository;
    }

    @Override
    public List<Movement> getMovements(String iban) throws Exception {
        if (Common.isValidIban(iban)) {
            try {
                return movementRepository.getAllMovementsByIban(iban);
            } catch (Exception ex) {
                throw new Exception(ex.getMessage());
            }
        }
        return new ArrayList<>();
    }
}
