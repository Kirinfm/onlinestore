package com.kirinsoft.onlinestore.onlinestore.file.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class FilesController {

    @GetMapping("/api/file")
    public ModelAndView getFile(ModelAndView modelAndView) {
        modelAndView.setViewName("freemarker");
        modelAndView.addObject("msg", "Hello");
        return modelAndView;
    }
}
