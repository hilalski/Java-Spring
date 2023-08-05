package com.example.smak.service;
import java.util.List;
import com.example.smak.dto.*;
public interface BarangService {
    public List<BarangDto> getBarangs();
    public BarangDto getBarang(Long barangId);
    public void updateBarang(BarangDto barangDto);
    public void deleteBarang(Long barangId);
    public void saveBarang(BarangDto barangDto);
}
