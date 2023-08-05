package com.example.smak.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.example.smak.dto.*;
import com.example.smak.model.*;
public class AsetMapper {
    public static AsetDto mapToAsetDto(Aset aset) {
        AsetDto asetDto = AsetDto.builder()
                .id(aset.getId())
                .barang(BarangMapper.mapToBarangDto(aset.getBarang()))
                .sumber(SumberMapper.mapToSumberDto(aset.getSumber()))
                .createdAt(aset.getCreatedAt())
                .updatedAt(aset.getUpdatedAt())
                .build();
        return asetDto;
    }

    public static Aset mapToAset(AsetDto asetDto) {
        Aset aset = Aset.builder()
                .id(asetDto.getId())
                .barang(BarangMapper.mapToBarang(asetDto.getBarang()))
                .sumber(SumberMapper.mapToSumber(asetDto.getSumber()))
                .createdAt(asetDto.getCreatedAt())
                .updatedAt(asetDto.getUpdatedAt())
                .build();
        return aset;
    }
}
