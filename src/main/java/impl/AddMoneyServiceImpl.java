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
}
