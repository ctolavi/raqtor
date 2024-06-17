package dev.ctolavi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
public record Player(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id,
        String name,
        String surnames,
        @CreationTimestamp
        LocalDate createDate,
        @UpdateTimestamp
        LocalDate updateDate
) {
}
