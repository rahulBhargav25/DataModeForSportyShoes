package com.example.datamodel.controller;

import com.example.datamodel.entity.Admin;
import com.example.datamodel.entity.User;
import com.example.datamodel.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class AdminHome {

    @Autowired
    private AdminRepo adminRepo;

    @RequestMapping("/change")
    public String change() {
        return "changeAdminPassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam Map<String,String>maps) {
        String email = maps.get("email");
        String oldPassword = maps.get("oldPassword");
        String newPassword = maps.get("newPassword");
        Admin admin = adminRepo.changePasswordByEmail(email,oldPassword,newPassword);
        if(admin == null) {
            return "adminNotFound";
        } else {
            return "adminLogin";
        }
    }

    @RequestMapping("/getUsers")
    public String getUsers(Model model) {
        List<User> users = adminRepo.getAllUsersForAdmin();
        model.addAttribute("users",users);
        return "adminHome";
    }

    @RequestMapping("/searchUser")
    public String searchUserByName(Model model, @RequestParam Map<String, String> maps) {
        String name = maps.get("name");
        List<User> users = adminRepo.searchUser(name);
        model.addAttribute("users",users);
        return "adminHome";
    }

}
