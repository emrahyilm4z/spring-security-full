package emrah.basicauth.repository;

import emrah.basicauth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
