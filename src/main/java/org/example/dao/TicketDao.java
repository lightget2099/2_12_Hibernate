package org.example.dao;

import org.example.entity.Ticket;

public interface TicketDao {

    void save(Ticket ticket);

    Ticket findById(Long id);

    void update(Ticket ticket);

    void deleteById(Long id);

}

