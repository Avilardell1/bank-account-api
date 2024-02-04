package service;

import model.Money;

public interface AddMoneyService {
    void addMoney(Money money) throws Exception;
    Money extractMoney(String amount, Money money) throws Exception;
}
