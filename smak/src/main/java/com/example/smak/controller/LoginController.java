package com.example.smak.controller;

import com.example.smak.dto.*;
import com.example.smak.model.User;
import com.example.smak.service.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Controller
@SessionAttributes("name")
public class LoginController {
    private String getLogedinUsername() {
        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register/daftar")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result, Model model, RedirectAttributes redirectAttributes)
    {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null){
            redirectAttributes.addFlashAttribute("errorMessage", "Registrasi Gagal! Email telah digunakan User lain. Silahkan login atau Gunakan Email lain!");
            return "redirect:/";
        }
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/";
        }

        userService.saveUser(userDto);
        redirectAttributes.addFlashAttribute("successMessage", "Registrasi berhasil!");
        return "redirect:/";
    }


}
