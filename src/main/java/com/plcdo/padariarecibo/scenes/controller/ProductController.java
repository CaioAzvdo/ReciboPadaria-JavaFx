package com.plcdo.padariarecibo.scenes.controller;
import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void registerProductScreen(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/plcdo/padariarecibo/scenes/RegisterProduct.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();

            Stage stage = new Stage();
            stage.setTitle("Registrar Produto");
            stage.setScene(new Scene(anchorPane));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
