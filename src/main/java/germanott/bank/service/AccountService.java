package germanott.bank.service;

import germanott.bank.entity.Account;
import germanott.bank.repository.AccountRepository;
import germanott.bank.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(Long id) {
        Optional<Account> optionalAccount = accountRepository.findById(id);
        return optionalAccount.get();
    }

    public Double consultBalance (Account account){

        return account.getBalance();
    }

}
