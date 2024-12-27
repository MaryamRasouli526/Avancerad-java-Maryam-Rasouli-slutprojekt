package org.example.todolistfe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.example.todolistfe.interfaces.InterfaceController;
import org.example.todolistfe.interfaces.InterfaceService;

/**
 * Klassen är till för att skapa de tre variabeln id, title och description för uppgifter.
 *
 * TaskController och TaskService klassen har tillgång till dessa privata attribut genom getters och setters.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see InterfaceController , InterfaceService ,TaskApplication,TaskController,TaskService
 */

@JsonIgnoreProperties(ignoreUnknown = true)//ToDo: Skapa en annotation som gör så att okända egenskaper i det inkommande JSON inte orsakar fel vid deserialisering.
public class Task {
    //ToDo: Skapa privata egenskaper som uppgifterna ska ha.
    private int id;
    private String title;
    private String description;


    public Task() { //ToDo: Skapa en tom konstruktor för deserialisering.

    }

    //ToDo: Låt en konstruktor ta emot egenskaperna och med "this" ska de hänvisa på de privata attributen ovan.
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    //ToDo: Skapa getters och setters för att klassen TaskController  och TestService ska ha tillgång till dem.


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
