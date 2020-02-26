package ru.job4j.hiber.persistence;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.hiber.models.Item;

import java.util.List;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 17.02.2020
 */
public class DBStore implements IStore {

    private static final DBStore INSTANCE = new DBStore();

    private final SessionFactory factory;

    private DBStore() {
        factory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    @Override
    public Item add(Item item) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.save(item);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public Item update(Item item) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.update(item);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public void delete(Item item) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.delete(item);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Item get(Item item) {
        Transaction tx = null;
        Item result = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            result = session.get(Item.class, item.getId());
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Item> getAll() {
        Transaction tx = null;
        List<Item> result = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            //result = session.createQuery("from Item", Item.class).list();
            //result = session.createQuery("from ru.job4j.hiber.models.Item").list();
            result = session.createQuery("FROM Item AS i ORDER BY i.id ASC").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

}
