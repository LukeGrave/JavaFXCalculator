module com.example.rechner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.rechner to javafx.fxml;
    exports com.example.rechner;
}