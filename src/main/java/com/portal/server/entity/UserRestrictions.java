package com.portal.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "User_Restrictions")
public class UserRestrictions {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "USER_ID")
        protected Long userId;

        @Column(name = "RESTRICTION_ID")
        protected Long restrictionId;

        public Id(){}

        public Id(Long userId, Long restrictionId) {
            this.userId = userId;
            this.restrictionId = restrictionId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return Objects.equals(userId, id.userId) && Objects.equals(restrictionId, id.restrictionId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(userId, restrictionId);
        }
    }

    @EmbeddedId
    @JsonIgnore
    private Id id = new Id();

    @ManyToOne
    @JoinColumn(
            name = "USER_ID",
            insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(
            name = "RESTRICTION_ID",
            insertable = false, updatable = false)
    private Restriction restriction;

    public UserRestrictions() {
    }

    public UserRestrictions(User user, Restriction restriction) {
        this.user = user;
        this.restriction = restriction;

        this.id.restrictionId = restriction.getId();
        this.id.userId = user.getId();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Restriction getRestriction() {
        return restriction;
    }

    public void setRestriction(Restriction restriction) {
        this.restriction = restriction;
    }
}
