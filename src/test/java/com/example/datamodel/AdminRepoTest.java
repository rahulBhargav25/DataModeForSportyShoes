package com.example.datamodel;

import com.example.datamodel.repository.AdminRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;

@SpringBootTest
public class AdminRepoTest {

    @Autowired
    EntityManager em;

    @Autowired
    AdminRepo adminRepo;

//    @Test
//    void testFilter() {
//        adminRepo.filterByDateAndCategory();
//    }

}
