package com.kamil.Mistrz_klawiatury.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username", unique = true)
    @NotBlank(message = "username mst be filled")
    private String username;

    @Column(name = "surname")
    @NotBlank(message = "surname mst be filled")
    private String surname;

    @Column(name = "password")
    @NotBlank(message = "password mst be filled")
    private String password;


    public Users withName(final String username) {
        this.username = username;
        return this;
    }

    public Users withSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public Users withPassword(final String password) {
        this.password = password;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getusername() {
        return username;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Users() {
    }

    public Users(String username, String surname, String password) {
        this.username = username;
        this.surname = surname;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
