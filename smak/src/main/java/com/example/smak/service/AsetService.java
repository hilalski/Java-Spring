package com.example.smak.service;
import java.util.List;
import com.example.smak.dto.*;


public interface AsetService {
    public List<AsetDto> getAsets();
    public AsetDto getAset(Long asetId);
    public void updateAset(AsetDto asetDto);
    public void deleteAset(Long asetId);
    public void saveAset(AsetDto asetDto);
    public boolean isBarangLinked(Long barangId);
    public boolean isSumberLinked(Long sumberId);

}
