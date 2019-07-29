package com.kamil.Mistrz_klawiatury.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "texts")
public class Texts {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "tittle")
    @NotBlank(message = "tittle must be filled")
    @Size(max = 60)
    private String tittle;

    @Column(name = "text")
    @NotBlank(message = "tittle must be filled")
    @Size(max = 1000)
    private String text;

    public Texts() {
    }

    public Texts(String tittle, String text) {
        this.tittle = tittle;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Texts{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
