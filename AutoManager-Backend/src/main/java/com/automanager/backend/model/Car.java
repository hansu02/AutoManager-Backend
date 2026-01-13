package com.automanager.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity // sıradan bir class değil, veritabanı tablosu
@Table(name = "cars") // tablonun adını tanımlar
public class Car {

    @Id // tablonun primary key olmasını sağlar
    @GeneratedValue(strategy = GenerationType.IDENTITY) //otomatik id numarası veren annotation
    private Long id;

    private String brand; // Marka
    private String model; // Model
    private Integer year; // Yıl
    private Double price; // Fiyat
    private String color; // Renk

    @Column(name = "is_sold")
    private boolean isSold;

    private LocalDate entryDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}