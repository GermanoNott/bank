package germanott.bank.util;

import germanott.bank.entity.Account;
import germanott.bank.entity.Agency;
import germanott.bank.entity.Bank;

import java.util.ArrayList;
import java.util.List;

public class BankUtil {
    public List<Account> getAccounts(){
        List<Account> accounts = new ArrayList<>();

        Bank bb = new Bank("001", "Banco do Brasil");

        Bank cef = new Bank("104", "Caixa Econômica Federal");
        //TODO implementar construtor lombok na agência e na conta. Seguir exemplo do banco.
        Agency agencyBb = new Agency();
        agencyBb.setBank(bb);
        agencyBb.setNumber(321);
        agencyBb.setDigit(2);
        agencyBb.setName("Agência Santos Dumont");

        Agency agencyCef = new Agency();
        agencyCef.setBank(cef);
        agencyCef.setNumber(654);
        agencyCef.setDigit(4);
        agencyCef.setName("Agência Iguatemi");

        Account accountBb = new Account();
        accountBb.setNumber(123);
        accountBb.setDigit(7);
        accountBb.setBalance(1000.50);
        accountBb.setAgency(agencyBb);
        accounts.add(accountBb);

        Account accountCef = new Account();
        accountCef.setNumber(456);
        accountCef.setDigit(8);
        accountCef.setBalance(2300.00);
        accountCef.setAgency(agencyCef);
        accounts.add(accountCef);

        return accounts;

    }
}
