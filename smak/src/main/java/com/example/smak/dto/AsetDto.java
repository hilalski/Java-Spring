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
public class AsetDto {
    private Long id;

    @NotNull(message = "Barang tidak boleh kososng.")
    private BarangDto barang;

    @NotNull(message = "Sumber tidak boleh kosong.")
    private SumberDto sumber;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedAt;
}
