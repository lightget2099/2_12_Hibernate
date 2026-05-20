package org.example.dao;

import org.example.entity.Client;

public interface ClientDao {
    void save(Client client);

    Client findById(Long id);

    void update(Client client);

    void deleteById(Long id);
}
