package org.ebia.songvision.business.models;

public class UserAuthorityServiceModel extends BaseServiceModel {
    private String authority;

    public UserAuthorityServiceModel() {
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
