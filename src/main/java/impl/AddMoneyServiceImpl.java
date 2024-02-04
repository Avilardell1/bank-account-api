package impl;

import lombok.NoArgsConstructor;
import model.Money;
import org.springframework.stereotype.Service;
import repository.MoneyRepository;
import service.AddMoneyService;

@Service
@NoArgsConstructor
public class AddMoneyServiceImpl implements AddMoneyService {

    private MoneyRepository moneyRepository;

    public AddMoneyServiceImpl (MoneyRepository moneyRepository) {
        this.moneyRepository = moneyRepository;
    }

    @Override
    public void addMoney(Money money) throws Exception {
        try {
            moneyRepository.save(money);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @Override
    public Money extractMoney(String amount, Money money) throws Exception {
        try {
            Money money_extract = moneyRepository.findById(String.valueOf(money.getId())).get();
            money_extract.setAmount(amount);
            moneyRepository.save(money_extract);
            return money_extract;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
