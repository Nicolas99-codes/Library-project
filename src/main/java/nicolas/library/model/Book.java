package nicolas.library.model;

import jakarta.persistence.*;

import java.util.Collection;


@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String release_year;

    private String imageUrl;

    private String addedDate;


    @ManyToMany
    @JoinTable(
            name = "book_author",
            joinColumns = @JoinColumn(name = "books_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
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

    public Book() {
    }

    public Book(Integer id, String title, String description, String release_year, String addedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.release_year = release_year;
        this.addedDate = addedDate;
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

    public Integer getStatusId() {
        return status.stream().findFirst().get().getId();
    }

    public Integer getGenreId() {
        return genres.stream().findFirst().get().getId();
    }

    public Integer getAuthorId() {
        return authors.stream().findFirst().get().getId();
    }

    public Integer getCategoryId() {
        return categories.stream().findFirst().get().getId();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
}