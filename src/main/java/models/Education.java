package models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "education", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Human> humans;

    public Education() {}

    public Integer getId() {
        return id;
    }

    public void addHuman(Human human)
    {
        human.setEducation(this);
        humans.add(human);
    }
    public void removeHuman(Human human)
    {
        humans.remove(human);
    }

    public Education(String name)
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
        return "Education{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
