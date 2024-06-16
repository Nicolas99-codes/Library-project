package nicolas.library.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Category {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private String category;

    private String country;

    private String bio;

    private String book_language;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private Collection<Book> books;

    public Category() {
    }

    public Category(Integer id, String category, String country, String bio, String book_language) {
        this.id = id;
        this.category = category;
        this.country = country;
        this.bio = bio;
        this.book_language = book_language;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBook_language() {
        return book_language;
    }

    public void setBook_language(String book_language) {
        this.book_language = book_language;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
