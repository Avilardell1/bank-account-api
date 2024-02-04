package repository;

import model.Money;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyRepository extends JpaRepository<Money, String> {
    Money updateMoney(String amount, Money money);
}
