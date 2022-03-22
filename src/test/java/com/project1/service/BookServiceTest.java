package com.project1.service;

import com.project1.dto.BookResponse;
import com.project1.dto.LibraryRequest;
import com.project1.entity.Book;
import com.project1.entity.Library;
import com.project1.repository.BookRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookServiceTest {
    @Autowired
    BookRepository bookRepository;
    BookService bookService;
    Library library = new Library();

    static int book1Id, book2Id;



//    @BeforeAll
//    static void setup(@Autowired BookRepository bookRepository){
//        Library library = new Library("Odense");
//        book1Id = bookRepository.save(new Book("2", "Name1", "Kevin Hansen", "Forlaget kevin", "2",library)).getId();
//        book2Id = bookRepository.save(new Book()).getId();
//    }
//    @BeforeEach
//    public void setupService (){
//         bookService = new BookService(bookRepository);
//    }
//
//    @Test
//    void getBooks() {
//        List<BookResponse> bookResponses = bookService.getBooks();
//        assertEquals(2, bookResponses.size());
//        assertInstanceOf(BookResponse.class, bookResponses.get(0));
//        assertEquals("Name1", bookResponses.get(0).getTitle());
//
//    }
//
////    @Test
////    void addBook() {
////        bookRepository.save(new Book("23", "Name2", "jesep Hansen", "Forlaget martin", "3533",library));
////        assertEquals("e", "");
////    }
//
//
//
//    @Test
//    void getBook() {
//
//    }
//
//    @Test
//    void editBook() {
//    }
//
//    @Test
//    void getBookToReservation() {
//    }
//
//    @Test
//    void deleteBook() {
//    }
}