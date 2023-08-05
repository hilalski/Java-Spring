package com.example.smak.service;

import com.example.smak.dto.SumberDto;

import java.util.List;

public interface SumberService {
    public List<SumberDto> getSumbers();
    public SumberDto getSumber(Long sumberId);
    public void updateSumber(SumberDto sumberDto);
    public void deleteSumber(Long sumberId);
    public void saveSumber(SumberDto sumberDto);
}
