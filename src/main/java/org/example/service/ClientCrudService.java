package org.example.service;

import org.example.dao.ClientDao;
import org.example.dao.ClientDaoImpl;
import org.example.entity.Client;

public class ClientCrudService {
    private final ClientDao clientDao = new ClientDaoImpl();

    public void save(Client client) {
        clientDao.save(client);
    }

    public Client findById(Long id) {
        return clientDao.findById(id);
    }

    public void update(Client client) {
        clientDao.update(client);
    }

    public void deleteById(Long id) {
        clientDao.deleteById(id);
    }

}
