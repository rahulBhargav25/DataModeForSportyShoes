package com.example.datamodel.repository;

import com.example.datamodel.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UserRepo {

    @Autowired
    EntityManager em;

    private UserRepo userRepo;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /*
     * find user by user id
     * using entity manager's find method
     * return type is user object*/
    public User findUserById(Long userId) {
        User user = em.find(User.class, userId);
        log.info("user object returned -> {}", user);
        return user;

    }

    public String userUpdate(Long userId, String oldPassword, String newPassword) {
        User user = userRepo.findUserById(userId);
        if (user.getPassword() == oldPassword) {
            user.setPassword(newPassword);
            if (user.getPassword() == newPassword) {
                return "Your password has been updated";
            } else {
                return "An error occured, password could not be updated";
            }
        } else {
            return "Kindly login with correct details";
        }
    }
//
//    public User verifyUser(String userName,) {
//
//    }
}
