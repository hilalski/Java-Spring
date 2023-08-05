package com.example.smak.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.example.smak.dto.BarangDto;
import com.example.smak.model.*;

public class BarangMapper {
    public static BarangDto mapToBarangDto(Barang barang) {
        BarangDto barangDto = BarangDto.builder()
                .id(barang.getId())
                .nama(barang.getNama())
                .kode(barang.getKode())
                .kategori(barang.getKategori())
                .jumlah(barang.getJumlah())
                .satuan(barang.getSatuan())
                .lokasi(barang.getLokasi())
                .tahun(barang.getTahun())
                .status(barang.getStatus())
                .createdAt(barang.getCreatedAt())
                .updatedAt(barang.getUpdatedAt())
                .build();
        return barangDto;
    }

    public static List<BarangDto> mapToBarangDtoList(List<Barang> barangs) {
        return barangs.stream()
                .map(BarangMapper::mapToBarangDto)
                .collect(Collectors.toList());
    }

    public static Barang mapToBarang(BarangDto barangDto) {
        Barang barang = Barang.builder()
                .id(barangDto.getId())
                .nama(barangDto.getNama())
                .kode(barangDto.getKode())
                .kategori(barangDto.getKategori())
                .jumlah(barangDto.getJumlah())
                .satuan(barangDto.getSatuan())
                .lokasi(barangDto.getLokasi())
                .tahun(barangDto.getTahun())
                .status(barangDto.getStatus())
                .createdAt(barangDto.getCreatedAt())
                .updatedAt(barangDto.getUpdatedAt())
                .build();
        return barang;
    }
    public static List<Barang> mapToBarangList(List<BarangDto> barangDtos) {
        return barangDtos.stream()
                .map(BarangMapper::mapToBarang)
                .collect(Collectors.toList());
    }
}
