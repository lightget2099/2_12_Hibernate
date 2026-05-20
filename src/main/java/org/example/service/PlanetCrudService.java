package org.example.service;

import org.example.dao.PlanetDao;
import org.example.dao.PlanetDaoImpl;
import org.example.entity.Planet;

public class PlanetCrudService {
    private final PlanetDao planetDao = new PlanetDaoImpl();

    public void save(Planet planet) {
        planetDao.save(planet);
    }

    public void update(Planet planet) {
        planetDao.update(planet);
    }

    public Planet findById(String id) {
        return planetDao.findById(id);
    }

    public void deleteById(String id) {
        planetDao.deleteById(id);
    }
}
