package com.example.datamodel.repository;


import com.example.datamodel.entity.Product;
import com.example.datamodel.entity.User;
import com.example.datamodel.entity.UserOrder;
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
public class ProductRepo {



    @Autowired
    EntityManager em;



    private Logger log = LoggerFactory.getLogger(this.getClass());

    public Product searchProduct(Long id) {
        Product product = em.find(Product.class,id);
        return product;
    }

    public List<Product> getAllProducts() {
        TypedQuery<Product> query = em.createNamedQuery("get_all_products",Product.class);
        List<Product> result =  query.getResultList();
        return result;
    }

    public String delProduct(Long id) {
        Product product = searchProduct(id);
        em.remove(product);
        return "deleted Successfully";
    }

    public Product addProduct(Product product) {
        em.persist(product);
        return product;
    }

    public Product updateProduct(Long id, Product product) {
        Product p1 = searchProduct(id);
        if(p1.getId()==null) {
            em.persist(product);
        } else {
            em.merge(product);

        }
        return product;
    }

    public String addProductToOrder(Long orderId, Long productId) {
        UserOrder userOrder = em.find(UserOrder.class,orderId);
        Product product = em.find(Product.class,productId);
        userOrder.addProducts(product);
        product.addUserOrders(userOrder);
        em.persist(userOrder);
        return "product added to orders successfully";

    }
}
