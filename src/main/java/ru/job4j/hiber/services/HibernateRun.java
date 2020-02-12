package ru.job4j.hiber.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.job4j.hiber.models.User;

import java.util.Calendar;
import java.util.List;

/**
 * @author John Ivanov (johnivo@mail.ru)
 * @since 12.02.2020
 */
public class HibernateRun {

    private SessionFactory factory;

    public void start() {
        factory = new Configuration()
                .configure()
                .buildSessionFactory();
    }

    public int saveOrUpdate(User user) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.saveOrUpdate(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return user.getId();
    }

    public User update(User user) {
        Transaction tx = null;
        User result = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            result = session.get(User.class, user.getId());
            result.setName("test updated");
            tx.commit();
            return result;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }

    public User findById(int id) {
        Transaction tx = null;
        User result = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            result = session.get(User.class, id);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return result;
    }


    public void delete(User user) {
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }


    public List<User> findAll() {
        List<User> users = null;
        Transaction tx = null;
        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            //users = session.createQuery("from User", User.class).list();
            users = session.createQuery("from ru.job4j.hiber.models.User").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        HibernateRun hiber = new HibernateRun();
        hiber.start();

        User user = new User();
        user.setName("test");
        user.setExpired(Calendar.getInstance());

        int id = hiber.saveOrUpdate(user);
        System.out.println(id);

        user = hiber.findById(id);
        System.out.println(user);

        hiber.update(user);
        user = hiber.findById(id);
        System.out.println(user);

        hiber.delete(user);
        List<User> users = hiber.findAll();
        System.out.println(users);
    }
}
