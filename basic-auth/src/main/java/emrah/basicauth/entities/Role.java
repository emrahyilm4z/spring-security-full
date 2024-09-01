package emrah.basicauth.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

public enum Role implements GrantedAuthority {

    ROLE_USER("USER"),
    ROLE_ADMIN("ADMIN"),
    ROLE_EMRAH("EMRAH");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String getAuthority() {
        return name();
    }
}
