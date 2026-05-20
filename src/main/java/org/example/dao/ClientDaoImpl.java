package org.example.dao;

import org.hibernate.Transaction;
import org.example.entity.Client;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

public class ClientDaoImpl implements ClientDao {

    @Override
    public void save(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(client);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Client findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
           return session.find(Client.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public void update(Client client) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(client);
            transaction.commit();
        }  catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Client client = session.find(Client.class, id);

            if (client != null) {
                session.remove(client);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
