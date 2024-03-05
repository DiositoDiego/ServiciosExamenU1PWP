package com.examen.examenU1.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    private @Id @GeneratedValue Long idBook;
    private String name, author, image;
    private Date releaseDate;
}
