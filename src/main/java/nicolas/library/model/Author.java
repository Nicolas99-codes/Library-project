package nicolas.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Collection;


@Entity
public class Author {
    @Id
    public Integer id;

    public String author_name;
    public String surname;

    @Column(length = 500)
    public String bio;

    public String country;

    @ManyToMany (mappedBy = "authors")
    Collection<Book> books;


    public Author() {
    }

    public Author(Integer id, String author_name, String surname, String bio, String country) {
        this.id = id;
        this.author_name = author_name;
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

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
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

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}