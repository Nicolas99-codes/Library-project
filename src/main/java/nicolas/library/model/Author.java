package nicolas.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Author {
    @Id
    public Integer id;

    public String name;
    public String surname;

    @Column(length = 500)
    public String bio;
    public Author() {
    }

    public Author(Integer id, String name, String surname, String bio) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.bio = bio;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    }