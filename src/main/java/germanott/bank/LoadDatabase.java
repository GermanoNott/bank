package germanott.bank;
import germanott.bank.entity.Bank;
import germanott.bank.repository.AccountRepository;
import germanott.bank.repository.AgencyRepository;
import germanott.bank.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(AccountRepository contaRepository, BankRepository bancoRepository, AgencyRepository agenciaRepository) {
        Bank bb = new Bank();
        bb.setCode("001");
        bb.setName("Banco do Brasil");
        Bank cef = new Bank();
        cef.setCode("104");
        cef.setName("Caixa Econoômica Federal");

//        Agency agenciaPenhorCEF = new Agency("Penhor","0154", 1,bancoCEF );
//        Agency agenciaRuralBB = new Agency("Rural","0022", 4,bancoBrasil );
//
//        Account contaBB = new Account("5555",5,1000.0, agenciaRuralBB);
//        Account contaCEF = new Account("0104",9,10000.0, agenciaPenhorCEF);


        return args -> {
            log.info("Preloading Banco Brasil" + bancoRepository.save(bb));
            log.info("Preloading CEF" + bancoRepository.save(cef));

//            log.info("Preloading Agência Rural" + agenciaRepository.save(agenciaRuralBB));
//            log.info("Preloading Agência Penhor" + agenciaRepository.save(agenciaPenhorCEF));
//
//            log.info("Preloading Conta BB" + contaRepository.save(contaBB));
//            log.info("Preloading Conta CEF" + contaRepository.save(contaCEF));


        };
    }
}