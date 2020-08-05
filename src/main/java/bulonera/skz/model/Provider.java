package bulonera.skz.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "providers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "direction")
    private String direction;

    @Column(name = "telephone",nullable = false)
    private String telephone;
}
