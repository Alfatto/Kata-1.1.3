package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private final SessionFactory sessionFactory = Util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.createSQLQuery("create table if not exists user1.user" +
                    "(id bigint primary key auto_increment, " +
                    "name varchar(100), " +
                    "lastname varchar(100), " +
                    "age tinyint);").executeUpdate();
            tx1.commit();
        } catch (HibernateException e) {
            tx1.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.createSQLQuery("drop table if exists user1.user;").executeUpdate();
            tx1.commit();
        } catch (HibernateException e) {
            tx1.rollback();
        } finally {
            session.close();
        }
    }


    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user = new User(name, lastName, age);
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.save(user);
            tx1.commit();
        } catch (HibernateException e) {
            tx1.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class, id);
        Transaction tx1 = session.beginTransaction();
        try {
            session.delete(user);
            tx1.commit();
        } catch (HibernateException e) {
            tx1.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        List<User> users = new ArrayList<>();
        try {
            users = session.createQuery("from User ").list();
            tx1.commit();
        } catch (HibernateException e) {
            tx1.rollback();
        } finally {
            session.close();
        }
        return users;
    }

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.createSQLQuery("truncate table user1.user;").executeUpdate();
            tx1.commit();
        } catch (HibernateException e) {
            tx1.rollback();
        } finally {
            session.close();
        }
    }
}
