module com.plcdo.padariarecibo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.plcdo.padariarecibo to javafx.fxml;
    opens com.plcdo.padariarecibo.scenes to javafx.fxml;
    exports com.plcdo.padariarecibo;

}