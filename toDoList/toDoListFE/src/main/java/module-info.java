module org.example.todolistfe {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    requires com.dlsc.formsfx;

    exports org.example.todolistfe;
    opens org.example.todolistfe to javafx.fxml;
}