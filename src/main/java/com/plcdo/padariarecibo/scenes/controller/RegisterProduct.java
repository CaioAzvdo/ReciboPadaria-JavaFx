package com.plcdo.padariarecibo.scenes.controller;

import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterProduct {


    @FXML
    private Button bt_delete;

    @FXML
    private Button bt_edit;

    @FXML
    private Button bt_save;

    @FXML
    private TextField tf_code;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_price;
    Product product = new Product();
    ProductDao productDao = new ProductDao();

    public void save(){
        product.setCode(tf_code.getText().toString());
        product.setName(tf_name.getText().toString());
        String priceText = tf_price.getText().replace(",", ".");
        product.setPrice(Double.parseDouble(priceText));
        productDao.save(product);
    }

}
