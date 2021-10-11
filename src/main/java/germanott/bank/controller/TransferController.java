package germanott.bank.controller;

import germanott.bank.entity.RevertTransferRequest;
import germanott.bank.entity.Transfer;
import germanott.bank.entity.TransferRequest;
import germanott.bank.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    @Autowired
    TransferService transferService;

    @PutMapping
    public ResponseEntity<List <Transfer>> transfer(@RequestBody TransferRequest transferRequest) throws Exception {
       return ResponseEntity.ok(transferService.transfer(transferRequest));

    }

    @PostMapping
    public ResponseEntity<List <Transfer>> revertTransfer(@RequestBody RevertTransferRequest revertTransferRequest) throws Exception {
        return ResponseEntity.ok(transferService.revertTransfer(revertTransferRequest));

    }
}
