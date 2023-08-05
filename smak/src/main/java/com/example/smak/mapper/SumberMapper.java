package com.example.smak.mapper;

import java.util.List;
import java.util.stream.Collectors;
import com.example.smak.dto.SumberDto;
import com.example.smak.model.*;
public class SumberMapper {
    public static SumberDto mapToSumberDto(Sumber sumber) {
        SumberDto sumberDto = SumberDto.builder()
                .id(sumber.getId())
                .vendor(sumber.getVendor())
                .alamat(sumber.getAlamat())
                .notelp(sumber.getNotelp())
                .createdAt(sumber.getCreatedAt())
                .updatedAt(sumber.getUpdatedAt())
                .build();
        return sumberDto;
    }

    public static List<SumberDto> mapToSumberDtoList(List<Sumber> sumbers) {
        return sumbers.stream()
                .map(SumberMapper::mapToSumberDto)
                .collect(Collectors.toList());
    }

    public static Sumber mapToSumber(SumberDto sumberDto) {
        Sumber sumber = Sumber.builder()
                .id(sumberDto.getId())
                .vendor(sumberDto.getVendor())
                .alamat(sumberDto.getAlamat())
                .notelp(sumberDto.getNotelp())
                .createdAt(sumberDto.getCreatedAt())
                .updatedAt(sumberDto.getUpdatedAt())
                .build();
        return sumber;
    }
    public static List<Sumber> mapToSumberList(List<SumberDto> sumberDtos) {
        return sumberDtos.stream()
                .map(SumberMapper::mapToSumber)
                .collect(Collectors.toList());
    }
}
