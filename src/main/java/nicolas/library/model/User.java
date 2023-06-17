package nicolas.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class User {
    @Id
    private Integer id;

    private String username;
    private String surname;
    private String email;
    private String user_role;

    @ManyToOne
    private Transaction transaction;

    public User() {
    }

    public User(Integer id, String username, String surname, String email, String user_role) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.user_role = user_role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }

    public Transaction getTransactions() {
        return transaction;
    }

    public void setTransactions(Transaction transaction) {
        this.transaction = transaction;
    }
}