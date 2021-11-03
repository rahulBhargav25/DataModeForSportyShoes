package com.example.datamodel.repository;


import com.example.datamodel.entity.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AdminRepo {

    @Autowired
    EntityManager em;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserOrderRepo userOrderRepo;

    @Autowired
    private ProductRepo productRepo;


    /*
    * Add a new admin if not exists already
    * Using persist of Entity Manager
    * if exist used merge to update the admin data
    * */
    public Admin saveAdmin(Admin admin) {
        if(admin.getId() == null) {
            em.persist(admin);
        } else {
            em.merge(admin);
        }
        return admin;
    }

    /*
    * find a admin using id
    * used Entity manager's find method
    * which returns the admin object*/
    public Admin findById(Long adminId) {
        Admin admin =em.find(Admin.class, adminId);
        log.info("admin retrieved -> {}",admin);
        return admin;
    }

    /*
    * update admin password
    * first find user using findById
    * then verify with oldPassword
    * then update newPassword*/
    public String changePassword(Long adminId, String oldPassword, String newPassword) {
        Admin admin = findById(adminId);
        if(admin.getPassword() == oldPassword) {
            admin.setPassword(newPassword);
            return "Password change successfull";
        } else {
            return "Password mismatch";
        }
    }

//    public List filterByDateAndCategory() {
//       userOrderRepo.
//    }


}
