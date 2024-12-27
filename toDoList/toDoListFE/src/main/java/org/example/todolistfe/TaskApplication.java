package org.example.todolistfe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.todolistfe.interfaces.InterfaceController;
import org.example.todolistfe.interfaces.InterfaceService;

import java.io.IOException;

/**
 * Klassen är en JavaFX-applikation som laddar och visar huvudfönstret för en "To-Do List"-app.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see InterfaceController,InterfaceService,Task,TaskController,TaskService
 */

public class TaskApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TaskApplication.class.getResource("task.fxml")); // ToDo: Ändra FXML-filen till namnet "task.fxml"
        Scene scene = new Scene(fxmlLoader.load(), 568, 510);//ToDo: Lägg til en standard storlek när fönstret öppnas så att den inte är ihop krympt.
        stage.setTitle("To-Do List!");//ToDo: Lägg titeln längst uppe i fönstret.
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}