package dao;

import models.Job;

public interface JobDao {
    Job findById(int id);

    void save(Job job);

    void update(Job job);

    void delete(Job job);
}
