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
public class SumberDto {
    private Long id;

    @NotEmpty(message = "Vendor tidak boleh kosong.")
    private String vendor;

    @NotEmpty(message = "Alamat tidak boleh kosong.")
    private String alamat;

    @NotNull(message = "Nomor Telepon tidak boleh kosong.")
    private String notelp;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdAt;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedAt;

}
