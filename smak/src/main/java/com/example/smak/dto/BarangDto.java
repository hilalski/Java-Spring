package com.example.smak.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BarangDto {
        private Long id;

        @NotEmpty(message = "Nama tidak boleh kosong.")
        private String nama;

        @NotEmpty(message = "Kode tidak boleh kosong.")
        private String kode;

        @NotNull(message = "kategori tidak boleh kosong.")
        private String kategori;

        @NotNull(message = "Jumlah tidak boleh kosong.")
        private Integer jumlah;

        @NotNull(message = "Satuan tidak boleh kosong.")
        private String satuan;

        @NotNull(message = "Lokasi tidak boleh kosong.")
        private String lokasi;

        @NotNull(message = "Tahun tidak boleh kosong.")
        private String tahun;

        @NotNull(message = "Status tidak boleh kosong.")
        private String status;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private Date createdAt;

        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
        private Date updatedAt;
    }

