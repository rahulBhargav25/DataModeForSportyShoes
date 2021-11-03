package com.example.datamodel.controller;

import com.example.datamodel.entity.User;
import com.example.datamodel.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UserLogin {

    @Autowired
    private UserRepo userRepo;

    @RequestMapping("login")
    public String loginPage() {
        return "userLogin";
    }

    @PostMapping("/userLogin")
    public String loginUser(@RequestParam Map<String, String> maps) throws Exception {
        String email = maps.get("email");
        String password = maps.get("password");
        User user = userRepo.verifyUser(email,password);
        if(user == null) {
            return "userNotFound";
        } else {
            return "userHome";
        }
    }
}
