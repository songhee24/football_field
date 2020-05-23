package com.football_field.football_field.Servicies;

import com.football_field.football_field.Entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService extends BaseService<User> {
    Boolean createUser(User customer);

    User findByUserName(String userName);

}
