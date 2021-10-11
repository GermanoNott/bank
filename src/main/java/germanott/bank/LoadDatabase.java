package germanott.bank;
import germanott.bank.entity.Account;
import germanott.bank.entity.Agency;
import germanott.bank.entity.Bank;
import germanott.bank.repository.AccountRepository;
import germanott.bank.repository.AgencyRepository;
import germanott.bank.repository.BankRepository;
import germanott.bank.repository.TransferRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository, BankRepository bancoRepository, AgencyRepository agencyRepository, TransferRepository transferRepository) {
        Bank bb = new Bank();
        bb.setCode("001");
        bb.setName("Banco do Brasil");

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

        Account accountCef = new Account();
        accountCef.setNumber(456);
        accountCef.setDigit(8);
        accountCef.setBalance(2300.00);
        accountCef.setAgency(agencyCef);

        return args -> {
            log.info("Delete tbTransfer");
            transferRepository.deleteAll();
            log.info("Delete tbAccount");
            accountRepository.deleteAll();
            log.info("Delete tbAgency");
            agencyRepository.deleteAll();
            log.info("Delete tbBank");
            bancoRepository.deleteAll();
            log.info("Preloading Banco Brasil" + bancoRepository.save(bb));
            log.info("Preloading CEF" + bancoRepository.save(cef));

            log.info("Preloading Agencia BB" + agencyRepository.save(agencyBb));
            log.info("Preloading Agencia CEF" + agencyRepository.save(agencyCef));

            log.info("Preloading Conta BB" + accountRepository.save(accountBb));
            log.info("Preloading Conta BB" + accountRepository.save(accountCef));

        };
    }
}