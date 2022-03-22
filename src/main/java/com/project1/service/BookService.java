package com.project1.service;

import com.project1.dto.BookRequest;
import com.project1.dto.BookResponse;
import com.project1.entity.Book;
import com.project1.error.ClientException;
import com.project1.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookResponse> getBooks() {
        List<Book> books = bookRepository.findAll();
        return BookResponse.getBooksFromEntities(books);
    }

    public BookResponse addBook(BookRequest body) {
        Book newBook = bookRepository.save(new Book(body));
        return new BookResponse(newBook, true);
    }

    //Tilføj fejlhåndtering
    public BookResponse getBook(int id, boolean all){
        Book book = bookRepository.findById(id).orElseThrow(()->new ClientException("Book not found", HttpStatus.NOT_FOUND));
        return new BookResponse(book, false);
    }



    public BookResponse editBook(BookRequest bookToEdit, int id) {
        Book book = bookRepository.findById(id).orElseThrow();
        book.setTitle(bookToEdit.getTitle());
        book.setAuthors(bookToEdit.getAuthors());
        book.setPublisher(bookToEdit.getPublisher());
        book.setPublishYear(bookToEdit.getPublishYear());
        return new BookResponse(bookRepository.save(book), true);
    }


    public Book getBookToReservation(int id){
        Book book = bookRepository.findById(id).orElseThrow(()->new ClientException("Book not found", HttpStatus.NOT_FOUND));
        return book;
    }

   /* public Book getBook(int id) {
        //findById returnerer en optional, så der skal checkes for null og pakkes ud
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (!optionalBook.isPresent()) {
            throw new RuntimeException("Book " + id + " not found");
        }
        //return indholdet af optionalBook
        return optionalBook.get();
    }
    */

    public void deleteBook (int id){
        bookRepository.deleteById(id);
    }

}


