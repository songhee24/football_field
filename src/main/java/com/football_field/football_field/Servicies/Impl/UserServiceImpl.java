package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Roles.Role;
import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Entities.Wallet;
import com.football_field.football_field.Repositories.RoleRepository;
import com.football_field.football_field.Repositories.UserRepository;
import com.football_field.football_field.Servicies.RoleService;
import com.football_field.football_field.Servicies.UserService;
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
        Optional<User> User= userRepository.findById(id);
        return User.get();
    }

    @Override
    public Boolean createUser(User user) {
        User userFromBD = findByUserName(user.getUsername());

        if (userFromBD != null){
            return false;
        }

        Role role = roleService.save(Role.builder().id(1L).roleName("ROLE_USER").build());
        Wallet wallet = Wallet.builder().balance(new BigDecimal(0)).build();
        user.setRoles(Collections.singleton(role));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setWallet(wallet);
        save(user);
        return true;
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
