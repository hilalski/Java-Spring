package com.example.smak.repository;
import com.example.smak.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BarangRepository extends JpaRepository<Barang, Long> {
}
