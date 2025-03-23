package com.plcdo.padariarecibo.scenes.util;

import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;

import java.util.ArrayList;
import java.util.List;

public class TestConnection {
    public static void main(String[] args) {
//        Product product = new Product();
//        ProductDao productDao = new ProductDao();
//        product.setCode("9091");
//        product.setName("Pão de Queijo Grande UN");
//        product.setPrice(4.50);
//        productDao.save(product);

        List<Product> products = new ArrayList<Product>();
        ProductDao productDao = new ProductDao();
        products = productDao.findAll();

        for (int i = 0; i < products.size(); i++) {
            System.out.println("ID: "+products.get(i).getId());
            System.out.println("Code: "+products.get(i).getCode());
            System.out.println("Name: "+products.get(i).getName());
            System.out.println("Price: "+products.get(i).getPrice());
            System.out.println("====================================");
        }

//        for (Product p : products) {
//            System.out.println("ID: "+p.getId());
//            System.out.println("Code: "+p.getCode());
//            System.out.println("Name: "+p.getName());
//            System.out.println("Price: "+p.getPrice());
//            System.out.println("====================================");
//        }

    }
}
