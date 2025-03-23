module com.plcdo.padariarecibo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires postgresql;


    opens com.plcdo.padariarecibo to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes.controller to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes.model to javafx.base;
    exports com.plcdo.padariarecibo;

}