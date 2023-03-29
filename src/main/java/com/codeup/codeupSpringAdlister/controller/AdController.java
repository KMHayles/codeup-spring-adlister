package com.codeup.codeupSpringAdlister.controller;

import com.codeup.codeupSpringAdlister.models.Ad;
import com.codeup.codeupSpringAdlister.models.User;
import com.codeup.codeupSpringAdlister.repository.AdRepository;
import com.codeup.codeupSpringAdlister.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdController {
    private final AdRepository adsDao;
    private final UserRepository userDao;

    public AdController(AdRepository adsDao, UserRepository userDao){
        this.adsDao = adsDao;
        this.userDao = userDao;
    }

    @GetMapping("/ads")
    public String allAds(Model model){
        model.addAttribute("ads", adsDao.findAll());
        return "/ads/index";
    }

    @GetMapping("/ads/create")
    public String postAdForm(){
        return "ads/create";
    }

    @PostMapping("/ads/create")
    public String postAd(@RequestParam(name="title") String title, @RequestParam(name="description") String description){
//        User user = Users.randomUser(userDao);
        User user = userDao.findById(1);
        Ad ad = new Ad(title, description);
        adsDao.save(ad);
        return "redirect:/ads";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model model){
        Ad ad = adsDao.findById(id);
        model.addAttribute(ad == null? new Ad("not found", "Could not find that ad") : ad);
        return "/ads/show";
    }

}







