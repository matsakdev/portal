package com.portal.server.dto;

import com.portal.server.security.Authority;

public class UserDTO {
    String name;
    String email;
    String authority;
    String note;

    public UserDTO() {
    }

    public UserDTO(String firstName, String email, String authority, String note) {
        this.name = firstName;
        this.email = email;
        this.authority = authority;
        this.note = note;
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName(String firstName) {
        this.name = firstName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
