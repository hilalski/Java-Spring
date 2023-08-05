package com.example.smak.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "barangs")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nama;
    @Column(nullable = false)
    private String kode;
    @Column(nullable = false)
    private String kategori;
    @Column(nullable = false)
    private Integer jumlah;
    @Column(nullable = false)
    private String satuan;
    @Column(nullable = false)
    private String lokasi;
    @Column(nullable = false)
    private String tahun;
    @Column(nullable = false)
    private String status;
    @Column(nullable = false)

    @CreationTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdAt;

    @Column(nullable = false)
    @UpdateTimestamp
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedAt;
}
