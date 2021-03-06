package dao;

import models.Human;

import java.util.List;

public interface HumanDao {
    Human findById(int id);

    void save(Human human);

    void update(Human human);

    void delete(Human human);

    List<Human> findAll();
}
