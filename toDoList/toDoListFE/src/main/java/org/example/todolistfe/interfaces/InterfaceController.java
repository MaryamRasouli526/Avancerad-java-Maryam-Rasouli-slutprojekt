package org.example.todolistfe.interfaces;

import javafx.event.ActionEvent;
import org.example.todolistfe.Task;
import org.example.todolistfe.TaskApplication;
import org.example.todolistfe.TaskController;
import org.example.todolistfe.TaskService;

/**
 * Interfacet skapar ett kontrakt/ritning på metoder som ska finnas i klassen TaskController.
 *
 * Den består av metoder sker exekveras beroende på vilken knapp i programmet man klickar på.
 *
 * Det finns metoder för att hämta alla uppgifter, lägga till en uppgift, ta bort en uppgift beroende på id:et, tömma textfälten, prioritera uppgifter och ladda uppgifter för att redigera dem.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see InterfaceService,Task,TaskApplication,TaskController,TaskService
 */

public interface InterfaceController {

    //ToDo: Skapa en kontrakt/ritning som hämtar alla uppgifter från backend och visa dem i TextArea.
    void getAllTasks(ActionEvent event);

    //ToDo: Skapa en kontrakt/ritning som lägger till en ny uppgift.
    void addNewTask(ActionEvent event);

    //ToDo: Skapa en kontrakt/ritning som tar bort en uppgift baserat på ID.
    void deleteTaskById(ActionEvent event);

    //ToDo: Skapa en kontrakt/ritning som tömmer alla input-fält.
    void clearFields(ActionEvent event);

    //ToDo: Skapa en kontrakt/ritning som prioriterar en uppgift baserat på dess ID.
    void prioritizeTaskById(ActionEvent event);

    //ToDo: Skapa en kontrakt/ritning som hämtar en specifik uppgift för redigering baserat på dess ID.
    void loadTaskForEditing(ActionEvent event);
}
