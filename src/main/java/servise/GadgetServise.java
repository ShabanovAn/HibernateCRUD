package servise;

import bl.HibernateUtil;
import bl.SessionUtil;
import entity.User;
import entityDao.UserDAO;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class GadgetServise extends SessionUtil implements UserDAO {
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
        }

    }

    @Override
    public List<User> getAll() {
        return getSession().createNativeQuery("select * from user", User.class)
                .getResultList();
    }

    @Override
    public User getById(int id) {
        return getSession().createNativeQuery("select * from user where id = :id", User.class).getSingleResult();

    }

    @Override
    public void update(User user) {
        openTransactionSession();
        getSession().saveOrUpdate(user);

    }

    @Override
    public void remove(User user) {
        openTransactionSession();
        getSession().remove(user);
        closeTransactionSession();

    }
}
