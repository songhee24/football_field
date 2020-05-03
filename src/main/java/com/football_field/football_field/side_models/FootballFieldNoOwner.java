package com.football_field.football_field.side_models;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FootballFieldNoOwner {

    Long id;
    String address;
    BigDecimal cost;

}
