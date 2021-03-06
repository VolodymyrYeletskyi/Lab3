package services;

import dao.impl.HumanDaoImpl;
import models.Human;

import java.util.List;

public class HumanService {
    private HumanDaoImpl humanDao = new HumanDaoImpl();

    public HumanService() {}

    public Human findHuman(int id) {
        return humanDao.findById(id);
    }

    public void saveHuman(Human human) {
        humanDao.save(human);
    }

    public void deleteHuman(Human human) {
        humanDao.delete(human);
    }

    public void updateHuman(Human human) {
        humanDao.update(human);
    }

    public List<Human> findAllHumans() {
        return humanDao.findAll();
    }

}
