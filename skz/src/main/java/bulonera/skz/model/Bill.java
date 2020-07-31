package bulonera.skz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "bill")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="id_customer_account")
    private  CustomerAccount customerAccount;

    @Column(name = "date")
    private Date date;

    @Column(name = "quantity_of_items")
    private int quantityOfItems;

    @Column(name = "price")
    private boolean price;

    @Column(name = "iva")
    private boolean iva;

    @Column(name = "total")
    private boolean total;
}
