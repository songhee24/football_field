package com.football_field.football_field.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "m_football_fields")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FootballPlayground {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "address")
    String address;

    @Column(name = "cost")
    BigDecimal cost;

    @Column(name = "hours")
    String hours;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    Owner owner;

}
