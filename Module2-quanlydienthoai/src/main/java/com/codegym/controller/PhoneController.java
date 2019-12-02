package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Phone;
import com.codegym.service.CategoryService;
import com.codegym.service.PhoneService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import java.util.Optional;


@Controller
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @Autowired
    private CategoryService categoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> categories(){
        return categoryService.findAll();
    }

    //Tìm kiếm  theo biến s
    @GetMapping("/phones")
    public ModelAndView listMaterials(@RequestParam("s") Optional<String> s, Pageable pageable) {
        //@PageableDefault(size = 5 ,sort = "price")
        Page<Phone> phones;
        if (s.isPresent()) {
            phones = phoneService.findAllByNameContaining(s.get(), pageable);
        } else {
            phones = phoneService.findAll(pageable);
        }

        ModelAndView modelAndView = new ModelAndView("/phone/list");
        modelAndView.addObject("phones",phones);
        return modelAndView;
    }


//    @GetMapping("/phones")
//    public ModelAndView listPhones(){
//        Iterable<Phone> phones = phoneService.findAll();
//        ModelAndView modelAndView = new ModelAndView("/phone/list");
//        modelAndView.addObject("phones",phones);
//        return modelAndView;
//    }

    @GetMapping("/create-phone")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone", new Phone());
        return modelAndView;
    }
    @PostMapping("/create-phone")
    public ModelAndView savePhone(@ModelAttribute("phone") Phone phone){
        phoneService.save(phone);
        ModelAndView modelAndView = new ModelAndView("/phone/create");
        modelAndView.addObject("phone",new Phone());
        modelAndView.addObject("message","New phone create successfully!");
        return modelAndView;
    }

}
