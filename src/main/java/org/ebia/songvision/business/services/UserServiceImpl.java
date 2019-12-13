package org.ebia.songvision.business.services;

import org.ebia.songvision.business.models.UserServiceModel;
import org.ebia.songvision.business.utilities.MappingUtility;
import org.ebia.songvision.data.entities.User;
import org.ebia.songvision.data.entities.UserAuthority;
import org.ebia.songvision.data.repositories.UserAuthorityRepository;
import org.ebia.songvision.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    // TODO: Export to GlobalConstants
    private static final String ROOT_USER_AUTHORITY = "Root";

    private static final String ADMINISTRATOR_USER_AUTHORITY = "Administrator";

    private static final String MODERATOR_USER_AUTHORITY = "Moderator";

    private static final String USER_USER_AUTHORITY = "User";

    private final MappingUtility mappingUtility;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final UserRepository userRepository;

    private final UserAuthorityRepository userAuthorityRepository;

    @Autowired
    public UserServiceImpl(MappingUtility mappingUtility, BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository, UserAuthorityRepository userAuthorityRepository) {
        this.mappingUtility = mappingUtility;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
        this.userAuthorityRepository = userAuthorityRepository;
    }

    private Set<UserAuthority> getAuthorities(String authority) {
        Set<UserAuthority> userAuthorities = new HashSet<>();

        userAuthorities.add(this.userAuthorityRepository.findByAuthority(authority));

        return userAuthorities;
    }

    @Override
    public UserServiceModel saveUser(UserServiceModel userServiceModel) {
        User userEntity = this.mappingUtility.map(userServiceModel, User.class);

        if(this.userRepository.findAll().size() == 0) {
            userEntity.setAuthorities(this.getAuthorities(ROOT_USER_AUTHORITY));
        } else {
            userEntity.setAuthorities(this.getAuthorities(USER_USER_AUTHORITY));
        }

        userEntity.setPassword(this.bCryptPasswordEncoder.encode(userEntity.getPassword()));

        return this.mappingUtility.map(
                this.userRepository.saveAndFlush(userEntity),
                UserServiceModel.class);
    }

    @Override
    public List<UserServiceModel> findAll() {
        return this.mappingUtility.map(
                this.userRepository.findAll(),
                UserServiceModel.class);
    }

    @Override
    public UserServiceModel findUserByUsername(String username) {
        return this.mappingUtility.map(
                this.userRepository.findByUsername(username),
                UserServiceModel.class);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("")); // TODO: Put message here...
    }
}
