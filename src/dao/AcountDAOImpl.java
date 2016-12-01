package dao;

import entity.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by zhangbaoning on 2016/11/28.
 */
public class AcountDAOImpl implements AccountDAO {

    private Session session;
    private Transaction transaction;

    public Session getSession() {
        return session;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public AcountDAOImpl() {
        Configuration configuration = new Configuration().configure();
        SessionFactory factory = configuration.buildSessionFactory();
        session = factory.openSession();
        transaction = session.beginTransaction();
    }

    @Override
    public void save(Account account) {
        session.save(account);
    }

    @Override
    public void del(Account account) {
        session.delete(account);
    }

    @Override
    public void update(Account account) {
        session.update(account);
    }

    @Override
    public Account get(String id) {
        Account account = (Account) session.get(Account.class,id);
        return account;

    }

    @Override
    public List getAll() {
        String hql = "from Account ";
        Query query = session.createQuery(hql);
        List list = query.list();
        return list;
    }
}
