package com.ebanking.userms.service;

import com.ebanking.userms.dto.StudentDTO;
import com.ebanking.userms.entities.Reservation;

/**
 * The interface Reservation service.
 */
public interface IReservationService {
  /**
   * Add reservation reservation.
   *
   * @param student the student
   * @return  the reservation
   */
Reservation addReservation(StudentDTO student);
}
