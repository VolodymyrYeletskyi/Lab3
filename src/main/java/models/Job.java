package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @ManyToMany(mappedBy = "jobs", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Human> humans;

    public Job() {}

    public Integer getId() {
        return id;
    }

    public Job(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Human> getHumans() {
        return humans;
    }

    public void setHumans(List<Human> humans) {
        this.humans = humans;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
