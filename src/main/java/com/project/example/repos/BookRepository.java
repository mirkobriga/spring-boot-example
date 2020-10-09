package com.project.example.repos;

import org.springframework.data.repository.CrudRepository;
import java.util.List;

import com.project.example.models.Book;
import com.project.example.models.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByUser(User user);

}
