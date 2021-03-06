package dao;

import models.Education;

public interface EducationDao {
    Education findById(int id);

    void save(Education education);

    void update(Education education);

    void delete(Education education);
}
