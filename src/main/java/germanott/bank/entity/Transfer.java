package germanott.bank.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_transfer")
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn
    private Account account;
    private Double value;
    private Date date;
    private String type;
    private String status;

    public Transfer(Account account, Double value, Date date, String type, String status) {
        this.account = account;
        this.value = value;
        this.date = date;
        this.type = type;
        this.status = status;
    }
}
