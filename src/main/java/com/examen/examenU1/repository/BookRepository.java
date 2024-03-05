package com.examen.examenU1.repository;

import com.examen.examenU1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY b.author ASC")
    List<Book> findByAuthor();

    @Query("SELECT b FROM Book b ORDER BY b.releaseDate ASC")
    List<Book> findByReleaseDate();

    @Query("SELECT b FROM Book b WHERE b.image != 'null'")
    List<Book> findByImage();
}
