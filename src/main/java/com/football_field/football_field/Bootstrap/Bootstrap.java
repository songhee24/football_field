package com.football_field.football_field.Bootstrap;

import com.football_field.football_field.Entities.Company;
import com.football_field.football_field.Entities.User;
import com.football_field.football_field.Entities.Roles.Role;
import com.football_field.football_field.Repositories.CompanyRepository;
import com.football_field.football_field.Repositories.RoleRepository;
import com.football_field.football_field.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Bootstrap implements CommandLineRunner {

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    UserRepository userRepository;
//
//    @Autowired
//    RoleRepository roleRepository;

    @Autowired
    CompanyRepository companyRepository;

/*    @Override
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
        Role adminRole = Role.builder()
                .roleName("ROLE_ADMIN")
                .user(admin)
                .build();
        Role role = Role.builder()
                .roleName("ROLE_USER")
                .user(user)
                .build();

        System.err.println("userRoleRepository.getByRoleName(userRole.getRoleName()) = " + roleRepository.getByRoleName(role.getRoleName()));
        System.err.println("userRoleRepository.getByRoleName(adminRole.getRoleName()) = " + roleRepository.getByRoleName(adminRole.getRoleName()));

        if (
                roleRepository.getByRoleName(role.getRoleName()) == null
                        || roleRepository.getByRoleName(adminRole.getRoleName()) == null
        ) {
            System.err.println("Repo SAVING");
            userRepository.save(admin);
            userRepository.save(user);

            roleRepository.save(adminRole);
            roleRepository.save(role);
        }*/


        //


    @Override
    public void run(String... args) throws Exception {
        Company company = Company.builder()
                .score(new BigDecimal(1000))
                .build();

        if (companyRepository.findAll().size() == 0) {
            companyRepository.save(company);
        }
    }
}

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
