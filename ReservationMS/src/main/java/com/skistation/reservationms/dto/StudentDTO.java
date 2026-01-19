package com.skistation.reservationms.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO {
    Long idStudent;
    String nomStudent;
    String prenomStudent;
    String studentSchool;
    Date dateOfBirth;
}
