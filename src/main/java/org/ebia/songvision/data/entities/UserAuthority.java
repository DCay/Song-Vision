package org.ebia.songvision.data.entities;

import org.hibernate.annotations.CollectionId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_authorities")
public class UserAuthority extends BaseEntity implements GrantedAuthority {
    private String authority;

    public UserAuthority() {
    }

    @Override
    @Column(name = "authority", nullable = false, unique = true)
    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
