package com.plcdo.padariarecibo.scenes.util;

import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;

public class TestConnection {
    public static void main(String[] args) {
        Product product = new Product();
        ProductDao productDao = new ProductDao();
        product.setCode("9090");
        product.setName("Pão de Queijo");
        product.setPrice(2.50);
        productDao.save(product);

    }
}
