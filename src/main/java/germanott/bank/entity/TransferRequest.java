package germanott.bank.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
public class TransferRequest implements Serializable {

    private Long idAccountOrigin;
    private Long idAccountDestiny;
    private Double value;



}
