package com.football_field.football_field.Entities;

import com.football_field.football_field.Statuses.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "m_request")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany
    @JoinColumn(name = "customer_id",referencedColumnName = "id")
    List<Customer> customers;


    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    Status status;

}
