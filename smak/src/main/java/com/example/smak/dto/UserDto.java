package com.example.smak.dto;

import jakarta.validation.constraints.Email;
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
public class UserDto {
    private Long id;

    @NotEmpty(message = "Nama tidak boleh kosong.")
    private String name;

    @NotEmpty(message = "Email tidak boleh kosong.")
    @Email
    private String email;

    @NotEmpty(message = "Password tidak boleh kosong.")
    private String password;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date createdAt;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date updatedAt;
}
