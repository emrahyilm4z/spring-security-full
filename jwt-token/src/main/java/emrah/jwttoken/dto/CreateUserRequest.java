package emrah.jwttoken.dto;

import emrah.jwttoken.entities.Role;
import lombok.Builder;

import java.util.Set;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@Builder
public record CreateUserRequest(
        String name,
        String userName,
        String password,
        Set<Role> authorities
){}
