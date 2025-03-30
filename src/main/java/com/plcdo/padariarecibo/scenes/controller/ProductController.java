package com.plcdo.padariarecibo.scenes.controller;
import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;
import com.plcdo.padariarecibo.scenes.service.DeleteProductAlert;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ProductController implements Initializable {
        @FXML
        private Button bt_delete;
        @FXML
        private Button bt_edit;
        @FXML
        private Button bt_save;
        @FXML
        private TableView<Product> tb_products;
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
        private List<Product> allProducts;
        private ObservableList<Product> productsObservableList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        prepareTable();
        showContextMenu();
    }

    void prepareTable(){
        tc_code.setCellValueFactory(new PropertyValueFactory<>("code"));
        tc_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        tc_price.setCellValueFactory(new PropertyValueFactory<>("price"));

        allProducts = productDao.findAll();
        productsObservableList = tb_products.getItems();
        productsObservableList.clear();
        productsObservableList.addAll(allProducts);
    }

    private ContextMenu createContextMenu(){
        ContextMenu contextMenu = new ContextMenu();

        MenuItem editItem = new MenuItem("Editar Produto");
        editItem.setOnAction(event -> {
            Product selectedProduct = tb_products.getSelectionModel().getSelectedItem();
            if (selectedProduct != null){
//                editProductScreen();
            }
        });
        MenuItem deleteItem = new MenuItem("Excluir Produto");
        deleteItem.setOnAction(event -> {
           Product selectedProduct = tb_products.getSelectionModel().getSelectedItem();
           if (selectedProduct != null){
               DeleteProductAlert.deleteProduct(selectedProduct);
               prepareTable();
           }
        });
        contextMenu.getItems().addAll(editItem, deleteItem);
        return contextMenu;
    }
    private void showContextMenu(){
        ContextMenu contextMenu = createContextMenu();
        tb_products.setRowFactory(tv -> {
            TableRow<Product> row = new TableRow<>();
            row.setOnContextMenuRequested(event -> {
                if (!row.isEmpty()){
                    contextMenu.show(row, event.getScreenX(), event.getScreenY());
                }
            });
            return row;
        });
    }


    public void registerProductScreen(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/plcdo/padariarecibo/scenes/RegisterProduct.fxml"));
            AnchorPane anchorPane = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Registrar Produto");
            stage.setScene(new Scene(anchorPane));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setOnHidden(event -> prepareTable());
            stage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
