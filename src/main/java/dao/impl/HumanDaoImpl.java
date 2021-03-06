package dao.impl;

import dao.HumanDao;
import models.Human;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class HumanDaoImpl implements HumanDao {
    public Human findById(int id)
    {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Human.class, id);
    }
    public void save(Human human)
    {
        EducationDaoImpl educationDao = new EducationDaoImpl();
        educationDao.save(human.getEducation());
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(human);
        transaction.commit();
        session.close();
    }
    public void update(Human human)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(human);
        transaction.commit();
        session.close();
    }
    public void delete(Human human)
    {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(human);
        tx1.commit();
        session.close();
    }

    public List<Human> findAll() {
        List<Human> users = (List<Human>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Human").list();
        return users;
    }
}
