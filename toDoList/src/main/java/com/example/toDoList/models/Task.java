package com.example.toDoList.models;

import com.example.toDoList.TaskApiApplication;
import com.example.toDoList.controllers.TaskController;

/**
 * Klassen är till för att skapa de tre variabeln id, title och decription för uppgifter.
 *
 * TaskController klassen har tillgång till dessa privata attribut genom getters och setters.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see TaskController,TaskApiApplication
 */

public class Task {
    //ToDo: Skapa privata egenskaper som uppgifterna ska ha.
    private int id;
    private String title;
    private String description;

    //ToDo: Låt en konstruktor ta emot egenskaperna och med "this" ska de hänvisa på de privata attributen ovan.
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //ToDo: Skapa getters och setters för att klassen TaskController ska ha tillgång till dem.

    public int getId() {
        return id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
