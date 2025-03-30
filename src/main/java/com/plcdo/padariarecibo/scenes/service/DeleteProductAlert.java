package com.plcdo.padariarecibo.scenes.service;

import com.plcdo.padariarecibo.scenes.dao.ProductDao;
import com.plcdo.padariarecibo.scenes.model.Product;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DeleteProductAlert {
    static ProductDao productDao = new ProductDao();

    public static void deleteProduct(Product product) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deletar Produto");
        alert.setHeaderText("Tem certeza que deseja excluir o produto?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            var id = product.getId();
            productDao.delete(id);
        }
        
    }
}
