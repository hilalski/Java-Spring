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
public class SumberServiceImpl implements SumberService{
    @Autowired
    private SumberRepository sumberRepository;
    @Override
    public List<SumberDto> getSumbers() {
        List<Sumber> sumbers = sumberRepository.findAll();
        List<SumberDto> sumberDtos = sumbers.stream()
                .map((sumber) -> (SumberMapper.mapToSumberDto(sumber)))
                .collect(Collectors.toList());
        return sumberDtos;
    }

    @Override
    public SumberDto getSumber(Long sumberId) {
        Optional<Sumber> sumber = sumberRepository.findById(sumberId);
        if (sumber.isPresent()) {
            return SumberMapper.mapToSumberDto(sumber.get());
        } else {
            return null;
        }
    }

    @Override
    public void updateSumber(SumberDto sumberDto) {
        Sumber sumber = SumberMapper.mapToSumber(sumberDto);
        sumberRepository.save(sumber);
    }

    @Override
    public void deleteSumber(Long sumberId) {
        sumberRepository.deleteById(sumberId);
    }

    @Override
    public void saveSumber(SumberDto sumberDto) {
        Sumber sumber = SumberMapper.mapToSumber(sumberDto);
        sumberRepository.save(sumber);}
}
