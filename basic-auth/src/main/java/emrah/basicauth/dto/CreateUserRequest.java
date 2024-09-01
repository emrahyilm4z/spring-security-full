package emrah.basicauth.dto;

import emrah.basicauth.entities.Role;
import lombok.Builder;

import java.util.Set;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

@Builder
public record CreateUserRequest (
        String name,
        String userName,
        String password,
        Set<Role> authorities
){}
