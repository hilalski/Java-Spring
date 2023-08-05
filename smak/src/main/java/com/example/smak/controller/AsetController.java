package com.example.smak.controller;

import com.example.smak.dto.*;
import com.example.smak.service.*;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

import java.util.List;
@Controller
public class AsetController {
    @Autowired
    private AsetService asetService;

    @Autowired
    private BarangService barangService;

    @Autowired
    private SumberService sumberService;

    @GetMapping("/aset")
    public String aset(Model model){
        List<AsetDto> asets = asetService.getAsets();
        model.addAttribute("asets", asets);
        return "aset";
    }

    @GetMapping("/aset/tambahaset")
    public String viewFormAddAsset(Model model) {
        model.addAttribute("barangs", barangService.getBarangs());
        model.addAttribute("sumbers", sumberService.getSumbers());
        model.addAttribute("aset", new AsetDto());
        return "tambahaset";
    }


    @RequestMapping(value = "/aset/tambahaset/submit", method = RequestMethod.POST)
    public RedirectView store(Model model,
                              @ModelAttribute("aset") AsetDto asetDto,
                              @RequestParam("barang_id") Long barang_id,
                              @RequestParam("sumber_id") Long sumber_id
    ) {
        model.addAttribute("aset", asetDto);
        asetDto.setBarang(barangService.getBarang(barang_id));
        asetDto.setSumber(sumberService.getSumber(sumber_id));
        asetService.saveAset(asetDto);
        return new RedirectView("/aset");
    }

    @GetMapping("/aset/{asetId}/edit")
    public String edit(Model model, @PathVariable Long asetId) {
        AsetDto aset = asetService.getAset(asetId);
        if (aset == null) {
            return "aset";
        }
        model.addAttribute("aset", aset);
        model.addAttribute("barangs",barangService.getBarangs());
        model.addAttribute("sumbers",sumberService.getSumbers());
        return "editaset";
    }

    @PostMapping("/aset/editaset/submit")
    public RedirectView editAset(@ModelAttribute("aset") AsetDto asetDto) {
        AsetDto existingAset = asetService.getAset(asetDto.getId());

        existingAset.setBarang(asetDto.getBarang());
        existingAset.setSumber(asetDto.getSumber());

        asetService.saveAset(existingAset);

        return new RedirectView("/aset");
    }

    @RequestMapping(value = "/aset/{asetId}/hapus", method = {RequestMethod.GET, RequestMethod.POST})
    public RedirectView hapusAset(@PathVariable Long asetId) {
        asetService.deleteAset(asetId);
        return new RedirectView("/aset");
    }

}
