package com.example.datamodel;

import com.example.datamodel.repository.AdminRepo;
import com.example.datamodel.repository.ProductRepo;
import com.example.datamodel.repository.UserOrderRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataModelApplication implements CommandLineRunner {

   @Autowired
   private UserOrderRepo userOrderRepo;

   @Autowired
   private ProductRepo productRepo;

   @Autowired
    private AdminRepo adminRepo;

    private Logger logger  = LoggerFactory.getLogger(this.getClass());


    public static void main(String[] args) {

        SpringApplication.run(DataModelApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

//
//            logger.info("list result -> {}",adminRepo.filterByDateAndCategory());
//           logger.info("gotcha -> {}", userOrderRepo.insert());
    }
}
