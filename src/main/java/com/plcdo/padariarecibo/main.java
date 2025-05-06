package com.plcdo.padariarecibo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

    Stage window;

    @Override
    public void start(Stage stage) throws Exception {

        window = stage;
        window.setTitle("Padaria Recibo");
        Parent rootScreen = FXMLLoader.load(getClass().getResource("scenes/Product.fxml"));
        Scene scene = new Scene(rootScreen);
        window.setScene(scene);
        window.show();

    }
}
