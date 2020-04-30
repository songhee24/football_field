package com.football_field.football_field.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "m_booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookedField {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    Customer customer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    FootballField footballField;

    @Column(name = "book_time")
    Date bookTime;

    @Column(name = "book_hours")
    int bookHours;



}
