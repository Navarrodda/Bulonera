package bulonera.skz.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    @Column(name = "cost")
    private boolean cost;

    @Column(name = "cost_with_iva")
    private boolean costWithIva;

    @Column(name = "cost_without_iva")
    private boolean costWithoutIva;
}
