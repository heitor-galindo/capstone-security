package com.skistation.studentms.client;

import com.skistation.studentms.config.ReservationEvent;
import com.skistation.studentms.entities.Student;
import com.skistation.studentms.repository.StudentRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ReservationConsumer {

    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    @KafkaListener(topics = "reservation-event", groupId = "reservation-group")
    public void consumeReservation(ReservationEvent reservationEvent) {
        Student studentFound = studentRepository.findById(reservationEvent.getStudentId()).orElse(null);
        if(studentFound == null) {
            log.error("Student with id {} not found",  reservationEvent.getStudentId());
            return;
        }

        System.out.println("Received reservation event with id " +
                reservationEvent.getReservationId() +
                " for student " + studentFound.getFirstName() +
                " with id " + studentFound.getId());
    }

}
