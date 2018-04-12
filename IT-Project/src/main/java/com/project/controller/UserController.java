package com.project.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

        if (bindingResult.hasErrors())
        {
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
    }
    
    @RequestMapping(value = {"/diary"}, method = RequestMethod.GET)
    public String note(Model model) {
        return "diary";
    }
    
    @RequestMapping(value = {"/diary"}, method = RequestMethod.POST)
    public String notepost(@ModelAttribute("diaryForm") Diary diary, Model m, Principal user) {
	    System.out.println("Name: " + diary.getTitle());
	    System.out.println("Name: " + diary.getNote());
	    //String title = diary.getTitle();
	    //@SuppressWarnings("unused")
	    //String content = diary.getNote();
	    @SuppressWarnings("unused")
		Date d = new Date();
		diary.setDate(new String(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
		diary.setUsername(user.getName());
		m.addAttribute("title", diary);
	    m.addAttribute("note", diary);
	    diaryService.save(diary);
	    return "redirect:listDiary";
    }     

    @RequestMapping(value="listDiary" , method = RequestMethod.GET)
	public String getOrders(Model model, Principal user){
		ArrayList<Diary> diarys = diaryService.findByUsername(user.getName());
		model.addAttribute("diary",diarys);
		return "listDiary";
	}
    
    @RequestMapping(value = {"/editDiary"},method = RequestMethod.GET)
    public String editDiary(@RequestParam("title") String title, Model m, Principal user) {
    	ArrayList<Diary> diarys = diaryService.findByUsername(user.getName());
    	for (Diary d : diarys){
    		if(d.getTitle().equals(title))
    			m.addAttribute("diary", d);
    	}
	    return "editDiary";
    }
    
    @RequestMapping(value = {"/editDiary"},method = RequestMethod.POST) 
    public String editDiary(@ModelAttribute("diary") Diary diary, Principal user) {
    	ArrayList<Diary> diarys = diaryService.findByUsername(user.getName());
    	for (Diary d : diarys){
    		if(d.getTitle().equals(diary.getTitle()))
    			diaryService.delete(d);
    	}
		diary.setDate(new String(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime())));
		diary.setUsername(user.getName());
	    diaryService.save(diary);
	    return "redirect:listDiary";
    }
    
    @RequestMapping(value = {"/deleteDiary"},method = RequestMethod.GET)
    public String deleteDiary(@RequestParam("title") String title, Model m, Principal user) {
    	ArrayList<Diary> diarys = diaryService.findByUsername(user.getName());
    	for (Diary d : diarys){
    		if(d.getTitle().equals(title))
    			m.addAttribute("diary", d);
    	}
	    return "deleteDiary";
    } 
    
    @RequestMapping(value = {"/deleteDiary"},method = RequestMethod.POST) 
    public String deleteDiary(@ModelAttribute("diary") Diary diary, Principal user) {
    	ArrayList<Diary> diarys = diaryService.findByUsername(user.getName());
    	for (Diary d : diarys)
    	{
	    	if(d.getTitle().equals(diary.getTitle()) && d.getNote().equals(diary.getNote()))
	    	{
	    		diaryService.delete(d);
	    	}
    	}
	    return "redirect:listDiary";
    }
}