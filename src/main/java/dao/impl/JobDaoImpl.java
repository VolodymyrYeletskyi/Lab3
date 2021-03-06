package dao.impl;

import dao.JobDao;
import models.Job;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class JobDaoImpl implements JobDao {
    public Job findById(int id)
    {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Job.class, id);
    }
    public void save(Job job)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(job);
        transaction.commit();
        session.close();
    }
    public void update(Job job)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(job);
        transaction.commit();
        session.close();
    }
    public void delete(Job job)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(job);
        tx1.commit();
        session.close();
    }
}
