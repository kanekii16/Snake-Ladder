module com.example.snake_ladders {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.snake_ladders to javafx.fxml;
    exports com.example.snake_ladders;
}