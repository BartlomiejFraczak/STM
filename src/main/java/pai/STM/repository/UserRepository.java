package pai.STM.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pai.STM.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Integer> {
    Optional<User> findFirstByEmail(String email);
}
