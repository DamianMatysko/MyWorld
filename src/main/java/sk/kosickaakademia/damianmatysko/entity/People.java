package sk.kosickaakademia.damianmatysko.entity;

import javax.persistence.*;

@Entity
@Table(name = "people")
public class People {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "year_of_birth")
    private String yearOfBirth;

    @JoinColumn(name = "nationality")
    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Nationality nationality;

    public People() {
    }

    public People(String fullName, String yearOfBirth) {
        this.fullName = fullName;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", yearOfBirth='" + yearOfBirth + '\'' +
                ", nationality=" + nationality +
                '}';
    }
}
