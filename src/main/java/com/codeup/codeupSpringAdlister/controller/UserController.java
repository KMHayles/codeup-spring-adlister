package com.codeup.codeupSpringAdlister.controller;

import com.codeup.codeupSpringAdlister.models.Ad;
import com.codeup.codeupSpringAdlister.models.User;
import com.codeup.codeupSpringAdlister.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userDao;

    public UserController(UserRepository userDao){
        this.userDao = userDao;
    }

    @GetMapping("/register")
    public String showRegistrationForm(){
        return "/register";
    }


    @GetMapping("/registers")
    public String showRegistrationForms(){
        return "/register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(name="username") String username, @RequestParam(name="email") String email, @RequestParam(name="password") String password){
        User user = new User(username, email, password);
        userDao.save(user);
        return "redirect:/ads";
    }

    @GetMapping("/user/{id}/ads")
    public String userAds(@PathVariable long id, Model model){
        User user = userDao.findById(id);
        List<Ad> userAds = user.getAds();
        model.addAttribute("userAds", userAds);
        return "/ads/userAds";
    }

}
