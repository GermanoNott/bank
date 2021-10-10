package germanott.bank.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
public class Transfer {
    private Account account;
    private Double value;
    private Date date;
    private String type;
    private Integer keyTransfer;

}
