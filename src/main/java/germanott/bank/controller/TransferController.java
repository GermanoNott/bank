package germanott.bank.controller;

import germanott.bank.entity.Account;
import germanott.bank.entity.Transfer;
import germanott.bank.entity.TransferRequest;
import germanott.bank.service.AccountService;
import germanott.bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    TransferService transferService;
    @PostMapping
    public ResponseEntity<List <Transfer>> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
       return ResponseEntity.ok(transferService.transfer(transferRequest));

    }
}
