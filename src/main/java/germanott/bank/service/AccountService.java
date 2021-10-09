package germanott.bank.service;

import germanott.bank.entity.Account;
import germanott.bank.util.BankUtil;

public class AccountService {
    private BankUtil bankUtil = new BankUtil();

    public Account getAccount(Integer number) {
        for(Account account:bankUtil.getAccounts()){
            if(number.equals(account.getNumber())){
                return account;
            }
        }
        return null;
    }

    public Double consultBalance (Account account){

        return account.getBalance();
    }

}
