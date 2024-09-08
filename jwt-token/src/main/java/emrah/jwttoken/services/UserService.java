package emrah.jwttoken.services;


import emrah.jwttoken.dto.CreateUserRequest;
import emrah.jwttoken.entities.User;
import emrah.jwttoken.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<User> getByUserName(String username) {

        return userRepository.findByUsername(username);
    }

    public User createUser(CreateUserRequest user) {

        User newUser = User.builder()
                .name(user.name())
                .username(user.username())
                .password(passwordEncoder.encode(user.password()))
                .authorities(user.authorities())
                .accountNonExpired(true)
                .credentialsNonExpired(true)
                .isEnable(true)
                .accountNonLocked(true)
                .build();

        userRepository.save(newUser);

        return newUser;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }
}
