package com.plcdo.padariarecibo.scenes.controller;

import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditProduct {
    @FXML
    private Button bt_save;

    @FXML
    private TextField tf_code;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_price;

    private Product product;
    ProductDao productDao = new ProductDao();


    public void setProduct(Product product){
        this.product = product;
        tf_code.setText(product.getCode());
        tf_name.setText(product.getName());
        tf_price.setText(String.valueOf(product.getPrice()));
    }
    public void edit(){
        try {
            if (validateFields()) {
                product.setCode(tf_code.getText().toString());
                product.setName(tf_name.getText().toString().toUpperCase());
                String priceText = tf_price.getText().replace(",", ".");
                product.setPrice(Double.parseDouble(priceText));
                productDao.update(product, product.getId());
                Stage stage = (Stage) bt_save.getScene().getWindow();
                stage.close();
            }
        }catch (NumberFormatException message){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error ao salvar o produto");
            alert.setContentText("Preço inválido");
            alert.show();
        }
    }
    public boolean validateFields(){
        StringBuffer message = new StringBuffer();

        if(tf_code.getText().isEmpty()){
            message.append("O campo Código é obrigatório\n");
        }
        if(tf_name.getText().isEmpty()){
            message.append("O campo Nome é obrigatório\n");
        }
        if(tf_price.getText().isEmpty()){
            message.append("O campo Preço é obrigatório\n");
        }
        if(message.length() > 0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error ao salvar o produto");
            alert.setContentText(message.toString());
            alert.show();
            return false;
        }else {
            return true;
        }
    }


}
