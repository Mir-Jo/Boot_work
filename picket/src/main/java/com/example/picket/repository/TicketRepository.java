package com.example.picket.repository;

import com.example.picket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
