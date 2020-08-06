package bulonera.skz.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "description_by_product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class DescriptionByProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name="id_product")
    private  Product product;

    @Column(name = "description")
    private String description;

    @Column(name = "weight")
    private boolean weight;

    @Column(name = "quantity")
    private int quantity;

}
