package com.project.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.diary.Diary;
import com.project.model.User;
import com.project.repository.DiaryRepository;
import com.project.service.SecurityServiceImp;
import com.project.service.UserServiceImp;
import com.project.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
    private UserServiceImp userServiceImp;

    @Autowired
    private SecurityServiceImp securityServiceImp;

    @Autowired
    private UserValidator userValidator;
    
    @Autowired
    private DiaryRepository diaryService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userServiceImp.save(userForm);

        securityServiceImp.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        return "welcome";
    }@RequestMapping(value = {"/diary"}, method = RequestMethod.GET)
    public String note(Model model) {
        return "diary";
    }
    
    @RequestMapping(value = {"/diary"}, method = RequestMethod.POST)
    public String notepost(@ModelAttribute("diaryForm") Diary diary, Model m)
    {
	    System.out.println("Name: " + diary.getTitle());
	    System.out.println("Name: " + diary.getNote());
	   // String title = diary.getTitle();
	   // @SuppressWarnings("unused")
	   //String content = diary.getNote();
	    m.addAttribute("title", diary);
	    m.addAttribute("note", diary);
	    diaryService.save(diary);
	    return "listDiary";
    }
    
    @RequestMapping(value = {"/listDiary"})
    public String listDiary(@ModelAttribute("title") Diary diary, Model m)
    {
	    String title = diary.getTitle();
	    ArrayList<Diary> titles = diaryService.findByTitle(title);
	    m.addAttribute("titles", title);
	    m.addAttribute("title", diary);
	    System.out.println("Name: " + diary.getTitle());
	    System.out.println("Name: " + titles);
	    diaryService.save(diary);
	    return "listDiary";
    }
    
}