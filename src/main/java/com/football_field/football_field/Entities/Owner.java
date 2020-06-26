package com.football_field.football_field.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "m_owner")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Owner {
    @Id
    Long id;

    @Column(name = "user_name")
    String username;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

}
