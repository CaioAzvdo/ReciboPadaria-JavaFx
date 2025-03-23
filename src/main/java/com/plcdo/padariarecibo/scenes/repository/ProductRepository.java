package com.plcdo.padariarecibo.scenes.repository;

import com.plcdo.padariarecibo.scenes.model.Product;

import java.util.List;

public interface ProductRepository {
    public Product searchWithId(Long id);
    public List<Product> findAll();
    public void save(Product product);
    public void delete(Long id);
    public void update(Product product, Long id);
}
