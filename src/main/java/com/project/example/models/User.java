package com.project.example.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity // This tells Hibernate to make a table out of this class
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private String email;

  private String password;
  @OneToMany(mappedBy = "user", cascade = { CascadeType.ALL })
  private List<Book> Books;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPasword() {
    return this.password;
  }

  public void setPassord(String password) {
    this.password = password;
  }

  public List<Book> getBooks() {
    return Books;
  }

  public void setBooks(List<Book> books) {
    Books = books;
  }

}
