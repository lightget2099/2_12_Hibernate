package org.example.dao;

import org.example.entity.Planet;
import org.example.utils.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlanetDaoImpl implements PlanetDao {
    @Override
    public void save(Planet planet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(planet);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Planet findById(String id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.find(Planet.class, id);
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Planet planet) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(planet);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void deleteById(String id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            Planet planet = session.find(Planet.class, id);

            if (planet != null) {
                session.remove(planet);
            }

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
