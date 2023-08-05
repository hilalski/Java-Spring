package com.example.smak.controller;

import com.example.smak.dto.*;
import com.example.smak.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Controller
public class BarangController {
    @Autowired
    private BarangService barangService;

    @Autowired
    private AsetService asetService;

    @GetMapping("/barang")
    public String barang(Model model){
        List<BarangDto> barangs = barangService.getBarangs();
        model.addAttribute("barangs", barangs);
        return "barang";
    }

    @GetMapping("/barang/tambahbarang")
    public String viewFormAddRequest(Model model) {
        model.addAttribute("barang", new BarangDto());
        return "tambahbarang";
    }

    @PostMapping("/barang/tambahbarang/submit")
    public RedirectView simpanBarang(Model model, @ModelAttribute("barang") BarangDto barangDto) {
        model.addAttribute("barang", barangDto);
        barangService.saveBarang(barangDto);
        return new RedirectView("/barang");
    }

    @PostMapping("/barang/editbarang/submit")
    public RedirectView editBarang(Model model, @ModelAttribute("barang") BarangDto barangDto) {
        model.addAttribute("barang", barangDto);

        BarangDto existingBarang = barangService.getBarang(barangDto.getId());

        existingBarang.setNama(barangDto.getNama());
        existingBarang.setKode(barangDto.getKode());
        existingBarang.setKategori(barangDto.getKategori());
        existingBarang.setJumlah(barangDto.getJumlah());
        existingBarang.setSatuan(barangDto.getSatuan());
        existingBarang.setLokasi(barangDto.getLokasi());
        existingBarang.setTahun(barangDto.getTahun());
        existingBarang.setStatus(barangDto.getStatus());

        barangService.saveBarang(existingBarang);

        return new RedirectView("/barang");
    }
    @GetMapping("/barang/{barangId}/edit")
    public String viewFormEditBarang(ModelMap model, @PathVariable Long barangId){
        BarangDto barang = barangService.getBarang(barangId);
        model.addAttribute("barang", barang);
        return "editbarang";
    }

    @RequestMapping(value = "/barang/{barangId}/hapus", method = {RequestMethod.GET, RequestMethod.POST})
    public String hapusBarang(@PathVariable Long barangId, RedirectAttributes redirectAttributes) {

        boolean isBarangLinked = asetService.isBarangLinked(barangId);
        if (isBarangLinked) {
            redirectAttributes.addFlashAttribute("error", "Barang tidak bisa dihapus karena telah terdaftar pada aset, Coba untuk menghapus aset!");
        } else {
            barangService.deleteBarang(barangId);
        }
        return "redirect:/barang";
    }




}
