package emrah.basicauth.services;

import emrah.basicauth.dto.CreateUserRequest;
import emrah.basicauth.entities.User;
import emrah.basicauth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUserName(String username) {

        return userRepository.findByUsername(username);
    }

    public void createUser(CreateUserRequest user) {

        User newUser = User.builder()
                .name(user.name())
                .username(user.userName())
                .password(passwordEncoder.encode(user.password()))
                .authorities(user.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnable(true)
                .accountNonLocked(true)
                .build();

        userRepository.save(newUser);

        User user1 = userRepository.findByUsername(user.userName()).orElseThrow();
        System.out.println(user1.getAuthorities());


    }

}
