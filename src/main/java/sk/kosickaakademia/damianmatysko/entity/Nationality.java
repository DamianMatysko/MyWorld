package sk.kosickaakademia.damianmatysko.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nationality")
public class Nationality {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_of_country")
    private String nameOfCountry;
    @Column(name = "Area")
    private String area;

    @Column(name = "population")
    private String population;


    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "nationality",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<People> peopleList;

    public Nationality() {
    }

    public Nationality(String nameOfCountry, String area, String population) {
        this.nameOfCountry = nameOfCountry;
        this.area = area;
        this.population = population;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfCountry() {
        return nameOfCountry;
    }

    public void setNameOfCountry(String nameOfCountry) {
        this.nameOfCountry = nameOfCountry;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id=" + id +
                ", nameOfCountry='" + nameOfCountry + '\'' +
                ", area='" + area + '\'' +
                ", population='" + population + '\'' +
                '}';
    }

    public void add(People people) {
        if (peopleList == null) {
            peopleList = new ArrayList<>();
        }
        peopleList.add(people);
        people.setNationality(this);
    }
}
