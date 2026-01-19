package com.skistation.studentms.config;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationEvent implements Serializable {
    private Long reservationId;
    private Long studentId;
}
