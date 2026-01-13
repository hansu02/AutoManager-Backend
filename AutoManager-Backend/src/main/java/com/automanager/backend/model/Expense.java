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
@Table(name = "expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description; // Örn: "Ofis Kirası" veya "BMW 320i Tamiri"
    private Double amount;      // Harcanan para (5000.0)
    private LocalDateTime date; // Ne zaman harcandı?

    // Bu gideri kim (hangi galerici) yaptı?
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // Bu gider özel bir araç için mi yapıldı? (Opsiyonel)
    // Eğer boşsa (null) genel giderdir (Kira gibi). Doluysa o araca aittir.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "car_id")
    private Car car;
}