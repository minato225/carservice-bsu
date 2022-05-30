package com.doskoch.fpm.web5.model.entity;

import com.doskoch.fpm.web5.model.auth.UserType;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {
    private int id;
    private String email;
    private String password;
    private int type;

    public User(String email, String password, int type) {
        this.email = email;
        this.password = password;
        this.type = type;
    }

    public User() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "Type")
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        var user = (User) o;

        if (id != user.id) return false;
        if (!Objects.equals(email, user.email)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return type == user.type;
    }

    @Override
    public int hashCode() {
        int result = type;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "email=" + email +
                ", password='" + password + '\'' +
                ", type='" + UserType.values()[type - 1] + '\'' +
                '}';
    }
}
