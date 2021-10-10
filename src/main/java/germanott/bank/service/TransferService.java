package germanott.bank.service;

import germanott.bank.entity.Account;
import germanott.bank.entity.Transfer;
import germanott.bank.entity.TransferRequest;
import germanott.bank.util.BankUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class TransferService {
    @Autowired
    AccountService accountService;

    public List<Transfer> transfer(TransferRequest transferRequest) throws Exception {
        Account accountOrigin = accountService.getAccount(transferRequest.getIdAccountOrigin());
        Account accountDestiny = accountService.getAccount(transferRequest.getIdAccountDestiny());
        if(accountOrigin.getBalance() >= transferRequest.getValue()){
            Integer key = new Random().nextInt();
            Transfer transferDebit = new Transfer(accountOrigin, transferRequest.getValue(),new Date(), "DEBIT", key);
            accountOrigin.setBalance(accountOrigin.getBalance() - transferRequest.getValue());
            Transfer transferCredit = new Transfer(accountDestiny, transferRequest.getValue(), new Date(), "CREDIT", key);
            accountDestiny.setBalance(accountDestiny.getBalance() + transferRequest.getValue());
            List<Transfer> transfers = new ArrayList<>();
            transfers.add(transferDebit);
            transfers.add(transferCredit);

            return transfers;
        }else{
            throw new Exception("Insuficient Balance");
        }
    }
    public List<Transfer> revertTransfer(Integer keyTransfer){



        return null;
    }
}
