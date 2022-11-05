package com.portal.server.payload;

import com.portal.server.security.Authority;

public class SignUpModeratorRequest extends SignUpRequest{
    private Authority authority;

    public Authority getAuthority() {
        return authority;
    }

    public void setAuthority(Authority authority) {
        this.authority = authority;
    }
}
