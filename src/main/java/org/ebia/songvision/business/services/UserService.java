package org.ebia.songvision.business.services;

import org.ebia.songvision.business.models.UserServiceModel;
import org.ebia.songvision.data.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    UserServiceModel saveUser(UserServiceModel userServiceModel);

    List<UserServiceModel> findAll();

    UserServiceModel findUserByUsername(String username);
}
