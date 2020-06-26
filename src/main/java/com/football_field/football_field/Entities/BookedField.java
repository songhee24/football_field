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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    User user; // show only id

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "id")
    FootballField footballField;

    @Column(name = "book_time")
    Date bookTime;

    @Column(name = "book_hours")
    int bookHours;



}
