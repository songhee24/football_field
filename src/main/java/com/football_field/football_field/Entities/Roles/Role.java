package com.football_field.football_field.Entities.Roles;

import com.football_field.football_field.Entities.User;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "m_user_role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotNull
    @Column(name = "role_name")
    String roleName;

    @Override
    public String getAuthority() {
        return getRoleName();
    }

    //    @ManyToMany(mappedBy = "roles")
//    Collection<User> users;

}
