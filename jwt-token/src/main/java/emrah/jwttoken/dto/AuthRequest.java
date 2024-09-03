package emrah.jwttoken.dto;

/**
 * @Author: emrahyilm4z
 * @Date: Sept 2024
 */

public record AuthRequest(
        String username,
        String password
) {
}
