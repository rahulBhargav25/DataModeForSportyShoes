package com.example.datamodel.repository;

import com.example.datamodel.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
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

    public User userUpdate(Long userId, String oldPassword, String newPassword) {
        User user =  em.find(User.class, userId);

        if (user.getPassword() == oldPassword) {
            user.setPassword(newPassword);
            if (user.getPassword() == newPassword) {
                return user;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public User addNewUser(User user) {
        em.persist(user);
        return user;
    }

    public List<User> getUsers() {
        TypedQuery<User> query = em.createNamedQuery("get_all_users",User.class);
        List<User> result =  query.getResultList();
        return result;
    }

    public User verifyUser(String email, String password) {
        User user = null;
        List<User> users = getUsers();
        for(int i = 0; i<users.size();i++) {
           user = users.get(i);
            if(user.getEmail().equals(email)) {
                if( user.getPassword().equals(password) ) {

                    break;
                }

            }
        }
        log.info("user -> {}",user);
        return user;
    }



}
