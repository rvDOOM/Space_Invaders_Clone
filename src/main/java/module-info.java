module com.example.space_invaders_clone {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.space_invaders_clone to javafx.fxml;
    exports com.example.space_invaders_clone;
}