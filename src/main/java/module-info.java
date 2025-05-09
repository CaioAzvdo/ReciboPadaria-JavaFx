module com.plcdo.padariarecibo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;
    requires postgresql;
    requires barbecue;
    requires org.flywaydb.core;


    opens com.plcdo.padariarecibo to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes.controller to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes.service to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes.model to javafx.base;
    opens db.migration;
    exports com.plcdo.padariarecibo;

}