package com.automanager.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sales")
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double salePrice;    // Kaça sattık?
    private LocalDateTime saleDate; // Ne zaman sattık?
    private String customerName; // Alan müşterinin adı

    // Hangi araba satıldı? (Bir satışta mutlaka bir araba olmalı)
    @OneToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    // Satışı hangi personel/yönetici yaptı?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}