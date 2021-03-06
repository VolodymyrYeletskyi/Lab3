package dao.impl;

import dao.EducationDao;
import models.Education;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

public class EducationDaoImpl implements EducationDao {
    public Education findById(int id)
    {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Education.class, id);
    }
    public void save(Education education)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(education);
        transaction.commit();
        session.close();
    }
    public void update(Education education)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(education);
        transaction.commit();
        session.close();
    }
    public void delete(Education education)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(education);
        tx1.commit();
        session.close();
    }
}
