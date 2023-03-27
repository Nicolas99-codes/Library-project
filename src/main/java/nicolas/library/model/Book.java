package nicolas.library.model;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String title;

    private String author;

    private String genre;

    private String category;

    @Column(length = 1000)
    private String description;

    private String status;

    private String release_year;

    private int views;

    @ManyToMany
    private Collection<Author> authors;

    public Book() {
    }

    public Book(Integer id, String title, String author, String genre, String category, String description, String status, String release_year, int views) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.category = category;
        this.description = description;
        this.status = status;
        this.release_year = release_year;
        this.views = views;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }

}