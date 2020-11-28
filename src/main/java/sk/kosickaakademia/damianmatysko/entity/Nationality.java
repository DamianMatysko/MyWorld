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
    @Column(name = "area")
    private String area;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "nationality",
            cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private List<People> peopleList;

    public Nationality() {
    }

    public Nationality(String nameOfCountry, String area) {
        this.nameOfCountry = nameOfCountry;
        this.area = area;
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
                ", peopleList=" + peopleList +
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
