module com.tbqueuenasabah.tbqueuenasabah {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.tbqueuenasabah.tbqueuenasabah to javafx.fxml;
    exports com.tbqueuenasabah.tbqueuenasabah;
}