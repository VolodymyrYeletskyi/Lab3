package models;

import javax.persistence.*;


@Entity
public class INN {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer number;

    public INN() {}

    @Override
    public String toString() {
        return "INN{" +
                "id=" + id +
                ", number='" + number  +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public INN(Integer number)
    {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
