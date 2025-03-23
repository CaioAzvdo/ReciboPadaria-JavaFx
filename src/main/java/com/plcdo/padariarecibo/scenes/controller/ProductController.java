package com.plcdo.padariarecibo.scenes.controller;
import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
        @FXML
        private Button bt_delete;
        @FXML
        private Button bt_edit;
        @FXML
        private Button bt_save;
        @FXML
        private TableView<?> tb_products;
        @FXML
        private TableColumn<?, ?> tc_code;
        @FXML
        private TableColumn<?, ?> tc_name;
        @FXML
        private TableColumn<?, ?> tc_price;
        @FXML
        private TextField tf_code;
        @FXML
        private TextField tf_name;
        @FXML
        private TextField tf_price;

        Product product = new Product();
        ProductDao productDao = new ProductDao();


    @FXML
    public void show() {
        String name = tf_name.getText().toString();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Nome do Produto");
        alert.setHeaderText("teste");
        alert.setContentText(name);
        alert.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void save(){
            product.setCode(tf_code.getText().toString());
            product.setName(tf_name.getText().toString());
            String priceText = tf_price.getText().replace(",", ".");
            product.setPrice(Double.parseDouble(priceText));
            productDao.save(product);
    }

}
