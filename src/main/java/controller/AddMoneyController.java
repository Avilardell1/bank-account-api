package controller;

import lombok.NoArgsConstructor;
import model.Money;
import org.springframework.web.bind.annotation.*;
import service.AddMoneyService;

@RestController
@RequestMapping("/bankAccount/addMoney")
@NoArgsConstructor
public class AddMoneyController {

    private AddMoneyService service;

    public AddMoneyController (AddMoneyService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void addMoney(@RequestBody Money money) throws Exception {
        this.service.addMoney(money);
    }

    @PutMapping("/")
    public Money extractMoney(@PathVariable String amount, @RequestBody Money money) throws Exception {
        return this.service.extractMoney(amount, money);
    }
}
