package com.excercise1.BookInventoryAuditingSystem.service;

import com.excercise1.BookInventoryAuditingSystem.dto.BookInputDTO;
import com.excercise1.BookInventoryAuditingSystem.dto.BookResponseDTO;
import com.excercise1.BookInventoryAuditingSystem.entity.Book;
import com.excercise1.BookInventoryAuditingSystem.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

public BookResponseDTO createBook(BookInputDTO input){
    Book book= Book.builder()
            .title(input.getTitle())
            .author(input.getAuthor())
            .isbn(input.getIsbn())
            .price(input.getPrice())
            .build();

    Book saved=bookRepository.save(book);
    return mapToResponse(saved);
}
public BookResponseDTO mapToResponse (Book book){
        return BookResponseDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .price(book.getPrice())
                .createdBy(book.getCreatedBy())
                .createdDate(book.getCreatedDate())
                .lastModifiedBy(book.getLastModifiedBy())
                .lastModifiedDate(book.getLastModifiedDate())
                .build();
}
 public void deleteBook(UUID id){
        bookRepository.deleteById(id);
 }
 public List<BookResponseDTO>getAllBooks(){
        return bookRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toUnmodifiableList());
 }

 public BookResponseDTO getBookById(UUID id){
        Book book=bookRepository.findById(id)
                .orElseThrow(()->new RuntimeException("not found"));
     return mapToResponse(book);

 }
    public BookResponseDTO updateBook(UUID id, BookInputDTO input) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        book.setTitle(input.getTitle());
        book.setAuthor(input.getAuthor());
        book.setIsbn(input.getIsbn());
        book.setPrice(input.getPrice());

        Book updated = bookRepository.save(book);
        return mapToResponse(updated);
    }


}
