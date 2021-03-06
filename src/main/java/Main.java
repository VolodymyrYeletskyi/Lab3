import dao.impl.EducationDaoImpl;
import models.Education;
import models.Human;
import models.INN;
import models.Job;
import services.HumanService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//Главная сущность - человек
//связь 1 к 1 - человек и его ИНН
//связь 1 к многим - человек и образование(у человека одно образование, но этим образование владеют много людей)
//связь многие к многим - человек и места работы(человек может работать в нескольких местах, и там же работают много разнх людей
public class Main {
    public static void main(String[] args) throws SQLException
    {
        HumanService humanService = new HumanService();
        List<Job> jobs = new ArrayList<Job>();
        jobs.add(new Job("Company A"));
        jobs.add(new Job("Company B"));
        jobs.add(new Job("Company C"));
        //EducationDaoImpl educationDao = new EducationDaoImpl();


        //create
        Education education = new Education("slesar");

        Human human = new Human("Sashko", 49, "man", 12300.50, new INN(234557), education, jobs);



        humanService.saveHuman(human);
        //read
        List<Human> humans = humanService.findAllHumans();
        System.out.println(humans.toString());
        //update
        human.setName("Vasya");
        humanService.updateHuman(human);
        Human human1 = humanService.findHuman(1);
        System.out.println(human1);
        //delete
        humanService.deleteHuman(human);

    }
}
