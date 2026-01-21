package com.ebanking.userms.repository;

import com.ebanking.userms.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/** The interface Reservation repository. */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {}
