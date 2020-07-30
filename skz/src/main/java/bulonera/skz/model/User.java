package bulonera.skz.model;


import bulonera.skz.model.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity(name = "Users")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false, unique = true)
    private String password;

    @Column(name = "direction")
    private String direction;

    @Column(name = "telephone", nullable = false, unique = true)
    private String telephone;

    @Column(name = "user_type", columnDefinition = "varchar(20) default 'CUSTOMER'")
    @Enumerated(value = EnumType.STRING)
    private UserType userType;




}
