package controller;

import lombok.NoArgsConstructor;
import model.Movement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.MovementService;

import java.util.List;

@RestController
@RequestMapping("/bankAccount/movements")
@NoArgsConstructor
public class MovementController {

    private MovementService service;

    public MovementController (MovementService service) {
        this.service = service;
    }

    @GetMapping("/{iban}")
    public List<Movement> getAccountMovementsByIban(@PathVariable String iban) throws Exception {
        return this.service.getMovements(iban);
    }
}
