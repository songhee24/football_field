package com.football_field.football_field.Servicies.Impl;

import com.football_field.football_field.Entities.Roles.Role;
import com.football_field.football_field.Entities.User;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
        User user = getUserByUserName(username);
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
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));// пароль шифруем
        Set<Role> roles = new HashSet<>();
        roles.add(roleService.getOne(1L)); //добавляем роль
        user.setRoles(roles);
        return save(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
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
