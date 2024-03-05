package com.examen.examenU1.service;

import com.examen.examenU1.model.Book;
import com.examen.examenU1.repository.BookRepository;
import com.examen.examenU1.utils.CustomResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public CustomResponse<List<Book>> getBooks() {
        CustomResponse<List<Book>> response = new CustomResponse<>();
        List<Book> books = bookRepository.findAll();
        if (!books.isEmpty()) {
            response.setData(books);
            response.setError(false);
            response.setMessage("Books found");
            response.setCode(200);
        } else {
            response.setData(null);
            response.setError(true);
            response.setMessage("No books found");
            response.setCode(404);
        }
        return response;
    }

    public CustomResponse<Book> getBookById(Long id) {
        CustomResponse<Book> response = new CustomResponse<>();
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            response.setData(book.get());
            response.setError(false);
            response.setMessage("Book found");
            response.setCode(200);
        } else {
            response.setData(null);
            response.setError(true);
            response.setMessage("Book not found");
            response.setCode(404);
        }
        return response;
    }

    public CustomResponse<List<Book>> getBooksByAuthor() {
        CustomResponse<List<Book>> response = new CustomResponse<>();
        List<Book> books = bookRepository.findByAuthor();
        if (!books.isEmpty()) {
            response.setData(books);
            response.setError(false);
            response.setMessage("Books found");
            response.setCode(200);
        } else {
            response.setData(null);
            response.setError(true);
            response.setMessage("No books found");
            response.setCode(404);
        }
        return response;
    }

    public CustomResponse<List<Book>> getBooksByReleaseDate() {
        CustomResponse<List<Book>> response = new CustomResponse<>();
        List<Book> books = bookRepository.findByReleaseDate();
        if (!books.isEmpty()) {
            response.setData(books);
            response.setError(false);
            response.setMessage("Books found");
            response.setCode(200);
        } else {
            response.setData(null);
            response.setError(true);
            response.setMessage("No books found");
            response.setCode(404);
        }
        return response;
    }

    public CustomResponse<List<Book>> getBooksByImg() {
        CustomResponse<List<Book>> response = new CustomResponse<>();
        List<Book> books = bookRepository.findByImage();
        if (!books.isEmpty()) {
            response.setData(books);
            response.setError(false);
            response.setMessage("Books found");
            response.setCode(200);
        } else {
            response.setData(null);
            response.setError(true);
            response.setMessage("No books found");
            response.setCode(404);
        }
        return response;
    }

    public CustomResponse<Book> updateBook(Long id, Book book) {
        CustomResponse<Book> response = new CustomResponse<>();
        Optional<Book> bookFound = bookRepository.findById(id);
        if (bookFound.isPresent()) {
            book.setIdBook(id);
            bookRepository.save(book);
            response.setData(book);
            response.setError(false);
            response.setMessage("Book updated successfully");
            response.setCode(200);
        } else {
            response.setData(null);
            response.setError(true);
            response.setMessage("Book not found");
            response.setCode(404);
        }
        return response;
    }

    public CustomResponse<Book> saveBook(Book book) {
        CustomResponse<Book> response = new CustomResponse<>();
        bookRepository.save(book);
        response.setData(book);
        response.setError(false);
        response.setMessage("Book saved successfully");
        response.setCode(200);
        return response;
    }

    public CustomResponse<Book> deleteBook(Long id) {
        CustomResponse<Book> response = new CustomResponse<>();
        try {
            bookRepository.deleteById(id);
            response.setData(null);
            response.setError(false);
            response.setMessage("Book deleted successfully");
            response.setCode(200);
            return response;
        } catch (EntityNotFoundException e) {
            response.setData(null);
            response.setError(true);
            response.setMessage("Book not found");
            response.setCode(404);
            return response;
        }
    }
}
