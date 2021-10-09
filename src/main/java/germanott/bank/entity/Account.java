package germanott.bank.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Account {
    private Agency agency;
    private Integer number;
    private Integer digit;
    private Double balance;



}
