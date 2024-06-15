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

    @Column(length = 1000)
    private String description;

    private String release_year;


    @ManyToMany
    private Collection<Author> authors;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_category",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private Collection<Category> categories;

    @ManyToMany
    @JoinTable(
            name = "book_genre",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private Collection<Genre> genres;

    @ManyToMany
    @JoinTable(
            name = "book_status",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id")
    )
    private Collection<Status> status;

    @ManyToOne
    private Transactions transactions;

    public Book() {
    }

    public Book(Integer id, String title, String author, String description, String release_year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.description = description;
        this.release_year = release_year;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Genre> getGenres() {
        return genres;
    }

    public void setGenres(Collection<Genre> genres) {
        this.genres = genres;
    }

    public Collection<Status> getStatus() {
        return status;
    }

    public void setStatus(Collection<Status> status) {
        this.status = status;
    }

    public Transactions getTransactions() {
        return transactions;
    }

    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }
}