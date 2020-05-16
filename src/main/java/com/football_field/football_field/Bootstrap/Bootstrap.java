package com.football_field.football_field.Bootstrap;

import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Entities.UserRole;
import com.football_field.football_field.Repositories.UserRepository;
import com.football_field.football_field.Repositories.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRoleRepository userRoleRepository;

    @Override
    public void run(String... args) throws Exception {
        User admin = User.builder()
                .login("admin")
                .password(passwordEncoder.encode("123"))
                .isActive(1)
                .build();
        User user = User.builder()
                .login("user")
                .password(passwordEncoder.encode("456"))
                .isActive(1)
                .build();
        UserRole adminRole = UserRole.builder()
                .roleName("ROLE_ADMIN")
                .user(admin)
                .build();
        UserRole userRole = UserRole.builder()
                .roleName("ROLE_USER")
                .user(user)
                .build();

        System.err.println("userRoleRepository.getByRoleName(userRole.getRoleName()) = " + userRoleRepository.getByRoleName(userRole.getRoleName()));
        System.err.println("userRoleRepository.getByRoleName(adminRole.getRoleName()) = " + userRoleRepository.getByRoleName(adminRole.getRoleName()));

        if (
                userRoleRepository.getByRoleName(userRole.getRoleName()) == null
                        || userRoleRepository.getByRoleName(adminRole.getRoleName()) == null
        ) {
            System.err.println("Repo SAVING");
            userRepository.save(admin);
            userRepository.save(user);

            userRoleRepository.save(adminRole);
            userRoleRepository.save(userRole);
        }
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
}
