package com.example.datamodel;

import com.example.datamodel.entity.User;
import com.example.datamodel.repository.UserRepo;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
public class UserRepoTest {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserRepo userRepo;

    @Test
    @Transactional
    public void findUserByEmailTest() {
        User user = userRepo.findUserById(1l);
        log.info("Username -> {}",user.getUserName());
        log.info("name -> {}", user.getName());
    }

}
