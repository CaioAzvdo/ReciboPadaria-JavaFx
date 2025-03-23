package com.plcdo.padariarecibo.scenes.dao;

import com.plcdo.padariarecibo.scenes.model.Product;
import com.plcdo.padariarecibo.scenes.repository.ProductRepository;
import com.plcdo.padariarecibo.scenes.util.ConnectionConfig;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductRepository {
    @Override
    public void searchWithId(Long id) {

    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        try{
            ResultSet rs = null;
            String sql = "SELECT * FROM products";
            PreparedStatement ps = ConnectionConfig.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                products.add(product);

            }
        }catch (Exception e){
            System.out.println("Error when trying to find all products: "+e.getMessage());
        }

        return products;
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
       String sql = "DELETE FROM products WHERE id = ?";
              
    }

    @Override
    public void update(Product product) {

    }
}
