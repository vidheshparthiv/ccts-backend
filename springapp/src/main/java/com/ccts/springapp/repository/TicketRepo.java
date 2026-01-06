package com.ccts.springapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ccts.springapp.model.Ticket;
@Repository
public interface TicketRepo extends JpaRepository<Ticket, Long> {

}
