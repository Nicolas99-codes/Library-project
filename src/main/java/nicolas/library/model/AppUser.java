package nicolas.library.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;
    private String password;
    private String firstName;
    private String surname;
    private String email;
    private String role;
    private String favoriteBook;
    private String ReadBook;

    @ManyToMany
    @JoinTable(
            name = "user_favoriteBooks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Collection<Book> favoriteBooks;

    @ManyToMany
    @JoinTable(
            name = "user_readBooks",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private Collection<Book> readBooks;

    public AppUser() {
    }

    public AppUser(String username, String password ,String surname, String email, String role) {
        this.username = username;
        this.password = password;
        this.surname = surname;
        this.email = email;
        this.role = role;
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

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
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

    public String getRole() {
        return role;
    }

    public void setRole(String user_role) {
        this.role = user_role;
    }

    public String getFavoriteBook() {
        return favoriteBook;
    }

    public void setFavoriteBook(String favoriteBook) {
        this.favoriteBook = favoriteBook;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public Collection<Book> getFavoriteBooks() {
        return favoriteBooks;
    }

    public void setFavoriteBooks(Collection<Book> favoriteBooks) {
        this.favoriteBooks = favoriteBooks;
    }

    public Collection<Book> getReadBooks() {
        return readBooks;
    }

    public void setReadBooks(Collection<Book> readBooks) {
        this.readBooks = readBooks;
    }


}