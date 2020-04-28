package com.football_field.football_field.models;

import com.football_field.football_field.Statuses.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfirmForOwner {
    Long requestId;
    Status status;

}
