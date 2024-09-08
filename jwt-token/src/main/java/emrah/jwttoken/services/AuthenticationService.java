package emrah.jwttoken.services;

import emrah.jwttoken.dto.AuthRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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

    private final AuthenticationManager authenticationManager;

    public AuthenticationService(JwtService jwtService, AuthenticationManager authenticationManager) {
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String authenticate(AuthRequest authRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));


        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authentication.getName());
        }
        log.info("Invalid User : {}", authentication.getName());
        throw new UsernameNotFoundException("User not found : " + authentication.getName());
    }
}
