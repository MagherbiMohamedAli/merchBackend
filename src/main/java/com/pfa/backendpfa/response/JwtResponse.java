package com.pfa.backendpfa.response;
import com.pfa.backendpfa.model.*;
import lombok.Data;

@Data
public class JwtResponse {
     private String token;
    private String type = "Bearer";
    private String username;
    private User user;

    public JwtResponse(String accessToken, String username, User user) {
        this.token = accessToken;
        this.username = username;
        this.user = user;

    }
}
