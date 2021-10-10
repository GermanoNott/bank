package germanott.bank.util;

import germanott.bank.entity.Account;
import germanott.bank.entity.Agency;
import germanott.bank.entity.Bank;
import germanott.bank.entity.Transfer;
import germanott.bank.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BankUtil {
    @Autowired
    private BankRepository bankRepository;
    public List<Transfer> transfers;
    public List<Account> accounts;

    public BankUtil() {
        //loadDateBase();
    }

    public void loadDateBase(){
        List<Account> accounts = new ArrayList<>();

        Bank bb = new Bank();
        bb.setCode("001");
        bb.setName("Banco do Brasil");
        bb = bankRepository.save(bb);
        Bank cef = new Bank();
        cef.setCode("104");
        cef.setName("Caixa Econoômica Federal");



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

        this.accounts = accounts;
        Transfer transferDebit = new Transfer(accountBb, 100.0,new Date(), "DEBIT", 12345);
        Transfer transferCredit = new Transfer(accountCef, 100.0, new Date(), "CREDIT", 12345);
        transfers = new ArrayList<>();
        transfers.add(transferDebit);
        transfers.add(transferCredit);

    }

}
