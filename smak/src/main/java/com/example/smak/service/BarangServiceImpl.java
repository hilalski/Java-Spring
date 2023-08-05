package com.example.smak.service;

import com.example.smak.dto.*;
import com.example.smak.mapper.*;
import com.example.smak.repository.*;
import com.example.smak.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BarangServiceImpl implements BarangService{
    @Autowired
    private BarangRepository barangRepository;

    @Override
    public List<BarangDto> getBarangs() {
        List<Barang> barangs = barangRepository.findAll();
        List<BarangDto> barangDtos = barangs.stream()
                .map((barang) -> (BarangMapper.mapToBarangDto(barang)))
                .collect(Collectors.toList());
        return barangDtos;
    }

    @Override
    public BarangDto getBarang(Long barangId) {
        Optional<Barang> barang = barangRepository.findById(barangId);
        if (barang.isPresent()) {
            return BarangMapper.mapToBarangDto(barang.get());
        } else {
            return null;
        }
    }

    @Override
    public void updateBarang(BarangDto barangDto) {
        Barang barang = BarangMapper.mapToBarang(barangDto);
        barangRepository.save(barang);
    }

    @Override
    public void deleteBarang(Long barangId) {
        barangRepository.deleteById(barangId);
    }

    @Override
    public void saveBarang(BarangDto barangDto) {
        Barang barang = BarangMapper.mapToBarang(barangDto);
        barangRepository.save(barang);}


}
