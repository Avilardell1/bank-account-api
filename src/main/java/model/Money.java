package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "money")
public class Money {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String iban;
    private String amount;
    private Date movement_date;
    private String comission;
    private Boolean isOurBank;
}
