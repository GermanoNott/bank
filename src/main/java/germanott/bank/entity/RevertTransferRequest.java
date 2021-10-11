package germanott.bank.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RevertTransferRequest {
    private Long idTransferCredit;
    private Long idTransferDebit;
}
