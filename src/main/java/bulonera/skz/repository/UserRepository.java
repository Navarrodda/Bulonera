package bulonera.skz.repository;

import bulonera.skz.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    @Query(value = "SELECT * from users u where u.email = ?1", nativeQuery = true)
    User getByEmail(String email);

    @Query(value = "SELECT u.* from users u where u.email = ?1 and u.password = ?2", nativeQuery = true)
    User getByUsername(String email, String password);

}
