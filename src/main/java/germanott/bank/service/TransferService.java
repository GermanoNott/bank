package germanott.bank.service;

import germanott.bank.entity.Account;
import germanott.bank.entity.RevertTransferRequest;
import germanott.bank.entity.Transfer;
import germanott.bank.entity.TransferRequest;
import germanott.bank.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TransferService {
    @Autowired
    AccountService accountService;
    @Autowired
    TransferRepository transferRepository;
    public List<Transfer> transfer(TransferRequest transferRequest) throws Exception {
        Account accountOrigin = accountService.getAccount(transferRequest.getIdAccountOrigin());
        Account accountDestiny = accountService.getAccount(transferRequest.getIdAccountDestiny());
        if(accountOrigin.getBalance() >= transferRequest.getValue()){

            Transfer transferDebit = new Transfer(accountOrigin, transferRequest.getValue(),new Date(), "DEBIT", "ACOMPLISHED");
            accountOrigin.setBalance(accountOrigin.getBalance() - transferRequest.getValue());
            Transfer transferCredit = new Transfer(accountDestiny, transferRequest.getValue(), new Date(), "CREDIT", "ACOMPLISHED");
            accountDestiny.setBalance(accountDestiny.getBalance() + transferRequest.getValue());
            List<Transfer> transfers = new ArrayList<>();
            transfers.add(transferDebit);
            transfers.add(transferCredit);
            transferRepository.save(transferDebit);
            transferRepository.save(transferCredit);

            return transfers;
        }else{
            throw new Exception("Insuficient Balance");
        }
    }

    public Transfer getTransfer(Long id) throws Exception {
        Optional<Transfer> optionalTransfer = transferRepository.findById(id);
        if (optionalTransfer.isPresent()){
            return optionalTransfer.get();
        }else{
            throw new Exception("Transfer not found");
        }
    }

    public List<Transfer> revertTransfer(RevertTransferRequest revertTransferRequest) throws Exception {
        Transfer transferCredit = getTransfer(revertTransferRequest.getIdTransferCredit());
        if(transferCredit.getAccount().getBalance() >= transferCredit.getValue()){
            Transfer transferDebit = getTransfer(revertTransferRequest.getIdTransferDebit());
            transferCredit.setStatus("REVERT");
            transferDebit.setStatus("REVERT");
            transferRepository.save(transferCredit);
            transferRepository.save(transferDebit);

            Transfer newTransferCredit = new Transfer(transferDebit.getAccount(),transferDebit.getValue(),new Date(),"CREDIT", "ACOMPLISHED");
            newTransferCredit.getAccount().setBalance(newTransferCredit.getAccount().getBalance() + transferDebit.getValue());
            Transfer newTransferDebit = new Transfer(transferCredit.getAccount(), transferCredit.getValue(), new Date(), "DEBIT", "ACOMPLISHED");
            newTransferDebit.getAccount().setBalance(newTransferDebit.getAccount().getBalance() - transferDebit.getValue());

            List<Transfer> revertTransfers = new ArrayList<>();
            revertTransfers.add(newTransferCredit);
            revertTransfers.add(newTransferDebit);
            revertTransfers.add(transferCredit);
            revertTransfers.add(transferDebit);
            transferRepository.save(newTransferCredit);
            transferRepository.save(newTransferDebit);
            return revertTransfers;

        }else{
            throw new Exception("Insuficient Balance");
        }

    }
}
