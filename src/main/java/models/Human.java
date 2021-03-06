package models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private String gender;
    private Double profit;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private INN inn;

    @ManyToOne(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn
    private Education education;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "HumanJob",
            joinColumns =  {
                @JoinColumn(name = "human")},
            inverseJoinColumns = {
                @JoinColumn(name = "job")})
    private List<Job> jobs;

    public Human() {}

    public Human(String name, Integer age, String gender, Double profit, INN inn, Education education, List<Job> jobs)
    {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profit = profit;
        this.inn = inn;
        this.education = education;
        this.jobs = jobs;
    }

    public INN getInn() {
        return inn;
    }


    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age + '\'' +
                ", gender=" + gender + '\'' +
                ", profit=" + profit + '\'' +
                ", education=" + education + '\'' +
                ", jobs=" + jobs.toString() +
                '}';
    }
}
