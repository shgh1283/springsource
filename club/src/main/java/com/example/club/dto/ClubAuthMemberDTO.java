package com.example.club.dto;

import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// UserDetails <--- User <---- ClubAuthMemberDTO

@ToString
@Getter
@Setter
public class ClubAuthMemberDTO extends User implements OAuth2User {

    private String email;
    private String name;
    private boolean fromSocial;

    private String password;
    private Map<String, Object> attr;

    // security 에서는 username = id
    public ClubAuthMemberDTO(String username, String password, boolean fromSocial,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.email = username;
        this.fromSocial = fromSocial;
        this.password = password;
    }

    public ClubAuthMemberDTO(String username, String password, boolean fromSocial,
            Collection<? extends GrantedAuthority> authorities, Map<String, Object> attr) {
        this(username, password, fromSocial, authorities);
        this.attr = attr;

    }

    @Override
    public Map<String, Object> getAttributes() {
        return this.attr;
    }
}
