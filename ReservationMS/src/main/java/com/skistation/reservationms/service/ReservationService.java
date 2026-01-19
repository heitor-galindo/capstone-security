package com.skistation.reservationms.service;

import com.skistation.reservationms.configuration.ReservationEvent;
import com.skistation.reservationms.dto.StudentDTO;
import com.skistation.reservationms.entities.Reservation;
import com.skistation.reservationms.repository.ReservationRepository;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReservationService implements IReservationService {

    @Autowired
    private KafkaTemplate<String, ReservationEvent> kafkaTemplate;
    private static final String TOPIC = "reservation-event";

  private final ReservationRepository reservationRepository;

  public ReservationService(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public Reservation addReservation(StudentDTO student) {


    Reservation res = new Reservation();
    if (student == null) {
      throw new IllegalArgumentException("Student does not exist.");
    }

    res.setStudentId(student.getIdStudent());
    res.setStartDate(LocalDate.now());
    res.setEndDate(LocalDate.now().plusYears(1));
    res.setEstValide(true);

    Reservation reservation = reservationRepository.save(res);

    ReservationEvent event = new ReservationEvent(reservation.getIdReservation(), reservation.getStudentId());
      kafkaTemplate.send(TOPIC, event);

    return reservation;
  }
}
