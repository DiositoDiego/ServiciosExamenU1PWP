package com.examen.examenU1.controller;

import com.examen.examenU1.model.Book;
import com.examen.examenU1.service.BookService;
import com.examen.examenU1.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//http://localhost:8080/api/books
@RequestMapping("/api/books")
@CrossOrigin(origins = "*")
public class BookController {

    /*
    * create database examenu1;
    * INSERT INTO `examenu1`.`book` (`id_book`, `release_date`, `author`, `name`) VALUES ('1', '2002-10-10', 'ADiego', 'El principito 1');
    * INSERT INTO `examenu1`.`book` (`id_book`, `release_date`, `author`, `image`, `name`) VALUES ('2', '2002-10-11', 'BDiego', 'una img', 'El principito 2');
    * INSERT INTO `examenu1`.`book` (`id_book`, `release_date`, `author`, `name`) VALUES ('3', '2002-10-12', 'CDiego', 'El principito 3');
    * */

    @Autowired
    BookService bookService;

    @GetMapping
    public CustomResponse<List<Book>> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public CustomResponse<Book> getBookById(@PathVariable Long id){
        return bookService.getBookById(id);
    }


    @GetMapping("/author")
    public CustomResponse<List<Book>> getBooksByAuthor(){
        return bookService.getBooksByAuthor();
    }

    @GetMapping("/release-date")
    public CustomResponse<List<Book>> getBooksByReleaseDate(){
        return bookService.getBooksByReleaseDate();
    }

    @GetMapping("/image")
    public CustomResponse<List<Book>> getBooksByImage(){
        return bookService.getBooksByImg();
    }

    @PutMapping("/{id}")
    public CustomResponse<Book> updateBook(@PathVariable Long id, @RequestBody Book book){
        return bookService.updateBook(id, book);
    }

    @PostMapping
    public CustomResponse<Book> saveBook(@RequestBody Book book){
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public CustomResponse<Book> deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }
}
