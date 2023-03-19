package nicolas.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;

@Entity
public class TransactionsList {
    @Id
    public Integer id;

    public String Book;

    public String title;

    public String Author;

    public String UserInfo;

    @Temporal(TemporalType.DATE)
    public Date LoanDate;

    @Temporal(TemporalType.DATE)
    public Date ReturnDate;

    public TransactionsList() {

    }

    public TransactionsList(Integer id, String book, String title, String author, String userInfo, Date loanDate, Date returnDate) {
        this.id = id;
        this.Book = book;
        this.title = title;
        this.Author = author;
        this.UserInfo = userInfo;
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

    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String userInfo) {
        this.UserInfo = userInfo;
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
}
