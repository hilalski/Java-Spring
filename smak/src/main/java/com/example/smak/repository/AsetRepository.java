package com.example.smak.repository;

import com.example.smak.model.Aset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsetRepository extends JpaRepository<Aset, Long> {
    boolean existsByBarangId(Long barangId);
    boolean existsBySumberId(Long sumberId);
}
