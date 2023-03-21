package nicolas.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


@Entity
public class Author {
    @Id
    public Integer id;

    public String authorName;
    public String surname;

    @Column(length = 500)
    public String bio;

    public String country;


    public Author() {
    }

    public Author(Integer id, String authorName, String surname, String bio, String country) {
        this.id = id;
        this.authorName = authorName;
        this.surname = surname;
        this.bio = bio;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorname(String authorName) {
        this.authorName = authorName;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}