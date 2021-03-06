package dao.impl;

import dao.INNDao;
import models.INN;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class INNDaoImpl implements INNDao {
    public INN findById(int id)
    {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(INN.class, id);
    }
    public void save(INN inn)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(inn);
        transaction.commit();
        session.close();
    }
    public void update(INN inn)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(inn);
        transaction.commit();
        session.close();
    }
    public void delete(INN inn)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(inn);
        tx1.commit();
        session.close();
    }
}
