package org.example.dao;

import org.example.entity.Client;
import org.example.entity.Planet;

public interface PlanetDao {
    void save(Planet planet);

    Planet findById(String id);

    void update(Planet planet);

    void deleteById(String id);

}
