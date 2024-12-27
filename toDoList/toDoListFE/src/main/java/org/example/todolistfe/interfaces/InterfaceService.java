package org.example.todolistfe.interfaces;

import org.example.todolistfe.Task;
import org.example.todolistfe.TaskApplication;
import org.example.todolistfe.TaskController;
import org.example.todolistfe.TaskService;

/**
 * Interfacet skapar ett kontrakt/ritning på metoder som ska finnas i klassen TaskService.
 *
 * Det finns metoder för att hämta alla uppgifter, lägga till en uppgift, ta bort en uppgift beroende på id:et, prioritera uppgifter och hämta genom id:et.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see InterfaceController,Task,TaskApplication,TaskController,TaskService
 */

public interface InterfaceService {

    //ToDo: Skapa en kontrakt/ritning som  hämtar alla uppgifter från backend.
    String getAllTasks() throws Exception;

    //ToDo: Skapa en kontrakt/ritning som lägger till en ny uppgift.
    String addNewTask(int id, String title, String description) throws Exception;

    //ToDo: Skapa en kontrakt/ritning som tar bort en uppgift baserat på ID.
    String deleteTaskById(int id) throws Exception;

    //ToDo: Skapa en kontrakt/ritning som prioriterar en uppgift baserat på ID.
    String prioritizeTaskById(int id, String tasks);

    //ToDo: Skapa en kontrakt/ritning som hämtar en specifik uppgift baserat på dess ID.
    Task getTaskById(int id) throws Exception;
}
