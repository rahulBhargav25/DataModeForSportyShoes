package com.example.datamodel.repository;

import com.example.datamodel.entity.Product;
import com.example.datamodel.entity.UserOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class UserOrderRepo {

    @Autowired
    EntityManager em;

    @Autowired
    private ProductRepo productRepo;

    private Logger log = LoggerFactory.getLogger(this.getClass());

    public UserOrder insert() {
        UserOrder userOrder = new UserOrder(700L);
        Product product = new Product("rahu");
        em.persist(userOrder);
        em.persist(product);

        userOrder.addProducts(product);
        product.addUserOrders(userOrder);
        em.persist(userOrder);
        return userOrder;
    }

    public Long totalCost(Long orderId) {
        UserOrder userOrder = em.find(UserOrder.class,orderId);
        List<Product> products = userOrder.getProducts();
        Long sum = 0L;
        for(int i = 0; i < products.size(); i++) {
            sum += products.get(i).getCost();
        }
        return sum;
    }

    public String addTotalCostToOrder(Long orderId) {
        Long sum = totalCost(orderId);
        UserOrder userOrder = em.find(UserOrder.class,orderId);
        userOrder.setTotal(sum);
        em.persist(userOrder);
        em.flush();
        return "here is total cart";
    }

//    public List getAllOrder() {
//
//    }

}
