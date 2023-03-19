package nicolas.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserList {
    @Id
    public Integer id;

    public String username;
    public String surname;
    public String email;
    public String user_role;

    public UserList() {
    }

    public UserList(Integer id, String username, String surname, String email, String user_role) {
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
}
