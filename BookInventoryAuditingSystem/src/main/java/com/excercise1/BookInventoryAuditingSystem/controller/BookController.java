package com.excercise1.BookInventoryAuditingSystem.controller;

import com.excercise1.BookInventoryAuditingSystem.dto.BookInputDTO;
import com.excercise1.BookInventoryAuditingSystem.dto.BookResponseDTO;
import com.excercise1.BookInventoryAuditingSystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
@PostMapping
    public ResponseEntity<BookResponseDTO> create(@RequestBody BookInputDTO input){
        return ResponseEntity.ok(bookService.createBook(input));
    }
@GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks(){
        return  ResponseEntity.ok(bookService.getAllBooks());
    }
    @GetMapping("/{id}")
   public ResponseEntity< BookResponseDTO> getBookById(@PathVariable UUID id){
        return ResponseEntity.ok(bookService.getBookById(id));
   }
   @PutMapping("/{id}")
   public ResponseEntity<BookResponseDTO>update( @PathVariable UUID id,@RequestBody BookInputDTO input){
        return  ResponseEntity.ok(bookService.updateBook(id,input));

   }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable UUID id) {
      bookService.deleteBook(id);
      return ResponseEntity.noContent().build();
  }

}
