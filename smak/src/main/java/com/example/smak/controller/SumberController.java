package com.example.smak.controller;

import com.example.smak.dto.*;
import com.example.smak.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.ui.Model;

import java.util.List;
@Controller
public class SumberController {
    @Autowired
    private SumberService sumberService;

    @Autowired
    private AsetService asetService;

    @GetMapping("/sumber")
    public String sumber(Model model){
        List<SumberDto> sumbers = sumberService.getSumbers();
        model.addAttribute("sumbers", sumbers);
        return "sumber";
    }

    @GetMapping("/sumber/tambahsumber")
    public String viewFormAddRequest(Model model) {
        model.addAttribute("sumber", new SumberDto());
        return "tambahsumber";
    }

    @PostMapping("/sumber/tambahsumber/submit")
    public RedirectView simpanSumber(Model model, @ModelAttribute("sumber") SumberDto sumberDto) {
        model.addAttribute("sumber", sumberDto);
        sumberService.saveSumber(sumberDto);
        return new RedirectView("/sumber");
    }

    @GetMapping("/sumber/{sumberId}/edit")
    public String viewFormEditSumber(ModelMap model, @PathVariable Long sumberId){
        SumberDto sumber = sumberService.getSumber(sumberId);
        model.addAttribute("sumber", sumber);
        return "editsumber";
    }

    @PostMapping("/sumber/editsumber/submit")
    public RedirectView editSumber(Model model, @ModelAttribute("sumber") SumberDto sumberDto) {
        model.addAttribute("sumber", sumberDto);

        SumberDto existingSumber = sumberService.getSumber(sumberDto.getId());

        existingSumber.setVendor(sumberDto.getVendor());
        existingSumber.setAlamat(sumberDto.getAlamat());
        existingSumber.setNotelp(sumberDto.getNotelp());

        sumberService.saveSumber(existingSumber);

        return new RedirectView("/sumber");
    }

    @RequestMapping(value = "/sumber/{sumberId}/hapus", method = {RequestMethod.GET, RequestMethod.POST})
    public String hapusSumber(@PathVariable Long sumberId, RedirectAttributes redirectAttributes) {
        boolean isSumberLinked = asetService.isSumberLinked(sumberId);
        if (isSumberLinked) {
            redirectAttributes.addFlashAttribute("error", "Sumber tidak bisa dihapus karena telah terdaftar pada aset, Coba untuk menghapus aset!");
        } else {
            sumberService.deleteSumber(sumberId);
        }
        return "redirect:/sumber";
    }

}
