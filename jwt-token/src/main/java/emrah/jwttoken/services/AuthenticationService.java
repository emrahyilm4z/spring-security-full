package emrah.jwttoken.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@Slf4j
@Service
public class AuthenticationService {

    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public String authenticate(Authentication authentication) {

        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authentication.getName());
        }
        log.info("Invalid User : {}", authentication.getName());
        throw new UsernameNotFoundException("User not found : " + authentication.getName());
    }
}
