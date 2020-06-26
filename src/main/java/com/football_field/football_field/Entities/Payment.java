package com.football_field.football_field.Entities;

import com.football_field.football_field.Statuses.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "m_payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @CreatedDate
    @Column(name = "created_date")
    Date createdDate = new Date();

    @ManyToOne
    @JoinColumn(name = "account_from_id")
    User accountFrom;

    @ManyToOne
    @JoinColumn(name = "account_to_id")
    Company accountTo;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    Status status;

//    @Column(name = "confirmation_code")
//    int confirmationCode;

}
