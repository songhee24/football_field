package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Roles.Role;
import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Entities.Wallet;
import com.football_field.football_field.Repositories.RoleRepository;
import com.football_field.football_field.Repositories.UserRepository;
import com.football_field.football_field.Servicies.UserService;
import com.football_field.football_field.side_models.LoginUserModel;
import com.football_field.football_field.side_models.SignUpUserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return user;
    }

    @Override
    public User getById(Long id) {
        Optional<User> User = userRepository.findById(id);
        return User.get();
    }

    @Override
    public User createUser(User user) {
        User userFromBD = findByUserName(user.getUsername());

        if (userFromBD != null) {
            System.out.println("username already have");
            return null;
        }

        Role role = roleService.save(Role.builder().id(1L).roleName("ROLE_USER").build());
        Wallet wallet = Wallet.builder().balance(new BigDecimal(0)).build();
        user.setRoles(Collections.singleton(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setWallet(wallet);

        return save(user);
    }

    @Override
    public SignUpUserModel getSignUpModel(String userName) {
        User foundUser = findByUserName(userName);
        return SignUpUserModel
                .builder()
                .id(foundUser.getId())
                .userName(foundUser.getUsername())
                .build();
    }

    @Override
    public User login(LoginUserModel loginUserModel) {
        User userFromBD = findByUserName(loginUserModel.getUserName());
        System.out.println("LOG_user from bd: " + userFromBD);
        if (userFromBD == null) {
            return null;
        }
        if (
                loginUserModel.getPassword().equals(userFromBD.getConfirmPassword())
        ) {
            return userFromBD;
        }
        return null;
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


    @Override
    public User save(User item) {
        return userRepository.save(item);
    }


}
