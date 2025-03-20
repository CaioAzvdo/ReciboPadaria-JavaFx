package com.plcdo.padariarecibo.scenes.dao;

import com.plcdo.padariarecibo.scenes.model.Product;
import com.plcdo.padariarecibo.scenes.repository.ProductRepository;
import com.plcdo.padariarecibo.scenes.util.ConnectionConfig;

import java.sql.PreparedStatement;
import java.util.List;

public class ProductDao implements ProductRepository {
    @Override
    public void searchWithId(Long id) {

    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void save(Product product) {
        try {
            String sql = "INSERT INTO products (code, name, price) VALUES (?, ?, ?)";

            PreparedStatement ps = ConnectionConfig.getConnection().prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.execute();

        }catch (Exception e) {
            System.out.println("Error when trying to save product: "+e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Product product) {

    }
}
