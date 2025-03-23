package com.plcdo.padariarecibo.scenes.dao;

import com.plcdo.padariarecibo.scenes.model.Product;
import com.plcdo.padariarecibo.scenes.repository.ProductRepository;
import com.plcdo.padariarecibo.scenes.util.ConnectionConfig;
import javafx.scene.control.Alert;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements ProductRepository {
    @Override
    public Product searchWithId(Long id) {
        Product product = null;
        try {
            String sql = "SELECT * FROM products WHERE id = ?";
            PreparedStatement ps = ConnectionConfig.getConnection().prepareStatement(sql);
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                product = new Product();
                product.setCode(rs.getString("code"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));

            }
        }catch (SQLException e){
            System.out.println("Error when trying to search with ID: "+ e.getMessage());
        }
            return product;
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error!");
            alert.setHeaderText("Erro no Código");
            alert.setContentText("Já existe um produto com esse código!");
            alert.show();
        }
    }

    @Override
    public void delete(Long id) {
       try {
           String sql = "DELETE FROM products WHERE id = ?";
           PreparedStatement ps = ConnectionConfig.getConnection().prepareStatement(sql);
           ps.setLong(1,id);
           ps.execute();
       }catch (SQLException e){
           System.out.println("Error when trying to delete product: "+e.getMessage());
       }
    }

    @Override
    public void update(Product product, Long id) {
        try{
            String sql = "UPDATE products SET code = ?, name = ?, price = ? WHERE id = ?";
            PreparedStatement ps = ConnectionConfig.getConnection().prepareStatement(sql);
            ps.setString(1, product.getCode());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setLong(4, id);
            ps.executeUpdate();

        }catch(SQLException e){
            System.out.println("Error when trying to update Product: "+e.getMessage());
        }
    }

}
