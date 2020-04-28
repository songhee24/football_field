package com.football_field.football_field.Entities;

import com.football_field.football_field.Statuses.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "m_booking")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "request_id",referencedColumnName = "id")
    List<Request> requests;

    @Column(name = "booking_time")
    String bookingTime;


}
