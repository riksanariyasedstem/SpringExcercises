package com.excercise1.BookInventoryAuditingSystem.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookInputDTO {

    private String title;
    private String author;
    private String isbn;
    private float price;
}
