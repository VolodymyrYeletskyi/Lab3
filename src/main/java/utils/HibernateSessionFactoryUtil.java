package utils;

import models.Education;
import models.Human;
import models.INN;
import models.Job;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory()
    {
        if(sessionFactory == null)
        {
            try {
                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(Education.class);
                configuration.addAnnotatedClass(Human.class);
                configuration.addAnnotatedClass(INN.class);
                configuration.addAnnotatedClass(Job.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;

    }
}
