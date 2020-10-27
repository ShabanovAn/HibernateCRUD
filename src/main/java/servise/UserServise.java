package servise;

import bl.HibernateUtil;
import bl.SessionUtil;
import entity.Gadget;
import entity.User;
import entityDao.GadgetDAO;
import entityDao.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserServise extends SessionUtil implements UserDAO {
    Session session;
    Transaction transaction;

    @Override
    public void add(User user) {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            if(transaction != null) {
                transaction.rollback();
            }
        }finally {
            if(session!= null) {
                closeSession();
            }
        }
    }

    @Override
    public List<User> getAll() {
        return getSession().createNativeQuery("select * from user", User.class)
                .getResultList();
    }

    @Override
    public User getById(int id) {
        User user;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            user =  session.createNativeQuery("select * from user where id = :id", User.class).getSingleResult();
        } catch (Exception e) {
                user = null;
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                closeSession();
            }
        }
        return user;
    }



    @Override
    public void update(User user) {
        try  (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void remove(User user) {
        session = HibernateUtil.getSessionFactory().openSession();
        openTransactionSession();
        getSession().remove(user);
        closeTransactionSession();


    }
}


