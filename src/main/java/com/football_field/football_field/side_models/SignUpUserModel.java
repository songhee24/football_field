package com.football_field.football_field.side_models;

import com.football_field.football_field.Entities.Wallet;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpUserModel {
    Long id;
    String userName;
}
