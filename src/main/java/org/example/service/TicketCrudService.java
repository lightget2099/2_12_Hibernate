package org.example.service;

import org.example.dao.TicketDao;
import org.example.dao.TicketDaoImpl;
import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;

public class TicketCrudService {
    private final TicketDao ticketDao = new TicketDaoImpl();

    private final ClientCrudService clientCrudService = new ClientCrudService();
    private final PlanetCrudService planetCrudService = new PlanetCrudService();

    public void save(Ticket ticket) {
        if (ticket.getClient() == null || ticket.getClient().getId() == null) {
            throw new IllegalArgumentException("Клієнта не вказаний або немає id в квитку");
        }

        Client newClient = clientCrudService.findById(ticket.getClient().getId());
        if (newClient == null) {
            throw new IllegalArgumentException("Клієнта взагалі не існує");
        }

        if (ticket.getFromPlanet() == null || ticket.getFromPlanet().getId() == null) {
            throw new IllegalArgumentException("Пункт відправлення не вказанний в квитку");
        }

        Planet fromPlanet = planetCrudService.findById(ticket.getFromPlanet().getId());
        if (fromPlanet == null) {
            throw new IllegalArgumentException("Такої планети не існує");
        }

        if (ticket.getToPlanet() == null || ticket.getToPlanet().getId() == null) {
            throw new IllegalArgumentException("Пункт призначення не вказанний в квитку");
        }

        Planet toPlanet = planetCrudService.findById(ticket.getToPlanet().getId());
        if (toPlanet == null) {
            throw new IllegalArgumentException("Такої планети не існує");
        }

        ticketDao.save(ticket);
    }

    public Ticket findById(Long id) {
        return ticketDao.findById(id);
    }

    public void update(Ticket ticket) {
        ticketDao.update(ticket);
    }

    public void deleteById(Long id) {
        ticketDao.deleteById(id);
    }
}
