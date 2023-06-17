package nicolas.library.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Transactions {
    @Id
    private Integer id;

    private String Book;

    private String title;

    private String Author;

    private String Users;

    @Temporal(TemporalType.DATE)
    private Date LoanDate;

    @Temporal(TemporalType.DATE)
    private Date ReturnDate;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Users user;


    public Transactions() {

    }

    public Transactions(Integer id, String book, String title, String author, String users, Date loanDate, Date returnDate) {
        this.id = id;
        this.Book = book;
        this.title = title;
        this.Author = author;
        this.Users = users;
        this.LoanDate = loanDate;
        this.ReturnDate = returnDate;
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

    public void setBook(String book) {
        this.Book = book;
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
        this.Author = author;
    }

    public String getUsers() {
        return Users;
    }

    public void setUsers(String users) {
        this.Users = users;
    }

    public Date getLoanDate() {
        return LoanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.LoanDate = loanDate;
    }

    public Date getReturnDate() {
        return ReturnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.ReturnDate = returnDate;
    }

    public void setBook(nicolas.library.model.Book book) {
        this.book = book;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}