package dao;

import models.INN;


public interface INNDao {
    INN findById(int id);

    void save(INN inn);

    void update(INN inn);

    void delete(INN inn);

}
