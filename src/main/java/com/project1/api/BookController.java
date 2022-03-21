package com.project1.api;

import com.project1.dto.BookRequest;
import com.project1.dto.BookResponse;
import com.project1.entity.Book;
import com.project1.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("api/books")
public class BookController {
    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<BookResponse> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/{id}")
    public BookResponse getBook(@PathVariable int id){
        return bookService.getBook(id, false);
    }

    @PostMapping
    public BookResponse addBook(@RequestBody BookRequest body){
        return bookService.addBook(body);
    }

    @PutMapping("/{id}")
    public BookResponse editBook(@RequestBody BookRequest body, @PathVariable int id){
        return bookService.editBook(body, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }

}
