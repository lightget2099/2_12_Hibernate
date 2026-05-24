package org.example;


import org.example.entity.Client;
import org.example.entity.Planet;
import org.example.entity.Ticket;
import org.example.service.ClientCrudService;
import org.example.service.PlanetCrudService;
import org.example.service.TicketCrudService;
import org.flywaydb.core.Flyway;

import java.time.LocalDateTime;

public class Main {
    public static void initMigration() {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:./spacetravel", "sa", "")
                .load();
        flyway.migrate();
    }


    public static void main(String[] args) {
        initMigration();
        System.out.println("Flyway ініціював і заповнив БД");

        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        System.out.println("======== Тестування Client ========");

        // create
        Client newClient = new Client();
        newClient.setName("Богдан");
        clientService.save(newClient);
        System.out.println("Створили клієнта з id: " + newClient.getId());

        // read
        Client foundClient = clientService.findById(newClient.getId());
        if (foundClient != null) {
            System.out.println("Знайдено клієнта: " + foundClient.getName());
        }

        // update
        if (foundClient != null) {
            foundClient.setName("Богдан онолвненний");
            clientService.update(foundClient);
            System.out.println("Ім'я після оновлення: " + clientService.findById(foundClient.getId()).getName());
        }

        // delete
        if (foundClient != null) {
            clientService.deleteById(foundClient.getId());
            System.out.println("Клієнта видалено. Пошук дає: " + clientService.findById(foundClient.getId()));
        }

        System.out.println("============== Тест Planet =================");

        Planet newPlanet = new Planet();
        newPlanet.setId("PLN1");
        newPlanet.setName("Нова Земля");
        planetService.save(newPlanet);
        System.out.println("Створили планету: " + newPlanet.getId() + " - " + newPlanet.getName());

        // read
        Planet foundPlanet = planetService.findById("PLN1");
        if (foundPlanet != null) {
            System.out.println("Знайдено планету: " + foundPlanet.getName());
        }

        // update
        if (foundPlanet != null) {
            foundPlanet.setName("Нова Земля v2.0");
            planetService.update(foundPlanet);
            System.out.println("Назва після оновлення: " + planetService.findById("PLN1").getName());
        }

        // delete
        planetService.deleteById("PLN1");
        System.out.println("Планету видалено. Шукаємо видаленну планету: " + planetService.findById("PLN1"));


        System.out.println("============== Тест Ticket =================");
        TicketCrudService ticketService = new TicketCrudService();



        Ticket ticket = new Ticket();
        ticket.setClient(clientService.findById(1L));
        ticket.setFromPlanet(planetService.findById("EARTH"));
        ticket.setToPlanet(planetService.findById("JUPI"));
        ticket.setCreatedAt(LocalDateTime.now());
        ticketService.save(ticket);
        System.out.println("Квиток успішно створено з ID: " + ticket.getId());



        try {
            Ticket invalidTicket = new Ticket();
            Client fakeClient = new Client();
            fakeClient.setId(999L);
            invalidTicket.setClient(fakeClient);
            invalidTicket.setFromPlanet(planetService.findById("EARTH"));
            invalidTicket.setToPlanet(planetService.findById("JUPI"));
            invalidTicket.setCreatedAt(LocalDateTime.now());

            ticketService.save(invalidTicket);
        } catch (IllegalArgumentException e) {
            System.out.println("Перевірка успішна: " + e.getMessage());
        }
    }
}