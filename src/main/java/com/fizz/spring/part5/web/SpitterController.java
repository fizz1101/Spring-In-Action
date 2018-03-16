package com.fizz.spring.part5.web;

import com.fizz.spring.part5.entity.Spitter;
import com.fizz.spring.part5.entity.SpitterForm;
import com.fizz.spring.part5.exception.BeanNotFoundException;
import com.fizz.spring.part5.service.SpitterService;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/spitter")
public class SpitterController {

    @Autowired
    private SpitterService spitterService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @RequestPart(value = "portrait") byte[] portrait,
            @Valid SpitterForm spitterForm, Errors errors,
            RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.getSpitter();
        MultipartFile portraitFile = spitterForm.getPortrait();
        if (portraitFile != null) {
            String filePath = "c://spittr_storage/uploads/file/picture/portrait/";
            String fileName = spitter.getUsername() + portraitFile.getOriginalFilename().substring(portraitFile.getOriginalFilename().indexOf("."));
            File folder = new File(filePath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            File file = new File(filePath + fileName);
            try {
                portraitFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        spitterService.save(spitter);
        redirectAttributes.addAttribute("username", spitter.getUsername());
        redirectAttributes.addFlashAttribute("spitter", spitter);
        return "redirect:/spitter/{username}";
    }

    @RequestMapping(value = "/{username}", method=RequestMethod.GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        if (model.containsAttribute("spitter")) {
            Spitter spitter = spitterService.findByUsername(username);
            if (spitter == null) {
                throw new BeanNotFoundException();
            } else {
                model.addAttribute(spitter);
            }
        }
        return "profile";
    }

}
