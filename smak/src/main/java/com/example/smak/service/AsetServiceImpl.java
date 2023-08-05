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
public class AsetServiceImpl implements AsetService{
    @Autowired
    private AsetRepository asetRepository;

    @Override
    public List<AsetDto> getAsets() {
        List<Aset> asets = asetRepository.findAll();
        List<AsetDto> asetDtos = asets.stream()
                .map((aset) -> AsetMapper.mapToAsetDto(aset))
                .collect(Collectors.toList());
        return asetDtos;
    }

    @Override
    public AsetDto getAset(Long asetId) {
        Optional<Aset> aset = asetRepository.findById(asetId);
        if (aset.isPresent()) {
            return AsetMapper.mapToAsetDto(aset.get());
        } else {
            return null;
        }
    }

    @Override
    public void updateAset(AsetDto asetDto) {
        Aset aset = AsetMapper.mapToAset(asetDto);
        asetRepository.save(aset);
    }

    @Override
    public void deleteAset(Long asetId) {
        asetRepository.deleteById(asetId);
    }

    @Override
    public void saveAset(AsetDto asetDto) {
        Aset aset = AsetMapper.mapToAset(asetDto);
        asetRepository.save(aset);
    }
    @Override
    public boolean isBarangLinked(Long barangId) {
        return asetRepository.existsByBarangId(barangId);
    }
    @Override
    public boolean isSumberLinked(Long sumberId) {
        return asetRepository.existsBySumberId(sumberId);
    }

}
