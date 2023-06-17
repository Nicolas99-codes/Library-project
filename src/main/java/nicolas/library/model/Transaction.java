package nicolas.library.model;

import jakarta.persistence.*;


@Entity
public class Transaction {
    @Id
    private Integer id;

    private String Book;

    private String title;

    private String Author;

    private String User;

    @ManyToOne
    private Book book;

    @ManyToOne
    private WebUser webUser;


    public Transaction() {

    }

    public Transaction(Integer id, String book, String title, String author, String user) {
        this.id = id;
        this.Book = book;
        this.title = title;
        this.Author = author;
        this.User = user;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBook() {
        return Book;
    }

    public void setBook(nicolas.library.model.Book book) {
        this.book = book;
    }

    public WebUser getWebUser() {
        return webUser;
    }

    public void setWebUser(WebUser webUser) {
        this.webUser = webUser;
    }

    public void setBook(String book) {
        Book = book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }
}