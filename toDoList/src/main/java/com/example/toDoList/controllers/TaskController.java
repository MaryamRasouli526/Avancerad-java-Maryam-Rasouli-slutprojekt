package com.example.toDoList.controllers;


import com.example.toDoList.TaskApiApplication;
import com.example.toDoList.models.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Klassen är en RestController i Java med Spring Boot och är en del av RESTful API.
 *
 * Den hanterar HTTP-förfrågningar för att läsa, skapa, uppdatera och ta bort uppgifter.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see Task,TaskApiApplication
 */

@RestController//ToDo: Skapa en annotation som gör att klassen fungerar som controller för HTTP-förfrågningar.
@RequestMapping("/api/tasks")//ToDo: Gör en annotation som säger att alla HTTP-anrop som matchar /api/tasks kommer att hanteras av denna controller.
public class TaskController {
    private List<Task> tasks = new ArrayList<>();//ToDo: Skapa en intern lista/ArrayList som sparar Task objekt.

    public TaskController() {} //ToDo: Ha en standardkonstruktör. Den ska vara tom den initierar inte data i detta fallet.

    /**
     * Hämtar uppgifter/Task objekt i ArrayList.
     * @return tasks
     */
    @GetMapping//ToDo: Skapa en annotation för HTTP GET-förfrågningar som hämtar uppgifter
    public List<Task> getAllTasks() { // ToDO: Hämta alla uppgifter som finns i listan.
        return tasks;
    }

    /**
     * Hämtar och söker uppgift genom titeln
     * @param title är rubriken till uppgiften/task
     * @return Status 200 om uppgiften matchade titel annars Status 404
     */
    @GetMapping("/title/{title}") //ToDo: Skapa en annotation för att hantera HTTP GET-förfrågningar för en specifik URL-väg, alltså /title. Vägparameter eller path variable är {title}.
    public ResponseEntity<Task> getTaskByTitle(@PathVariable String title) { //ToDo: Skapa en wrapper (ResponseEntity<Task>) som returnerar både HTTP-status och eventuell en uppgift i body.
    //ToDo: Skapa en annotation med  @PathVariable. Den ska vara av typen String  ha variabelnamnet title. Detta binder URL-parametern {title} till metodargumentet title.
        return tasks.stream()//ToDo: Iterera över listan tasks för att möjliggöra filtrering, sökning och bearbetning av uppgifter.

                //ToDo: Filtrera strömmen för att hitta uppgifter där titeln matchar argumentet "title".
                // Jämförelsen är case-insensitiv (t.ex. "shopping" matchar "Shopping").
                .filter(task -> task.getTitle().equalsIgnoreCase(title))

                //ToDo: Skapa .findFirst() som  söker efter den första uppgiften som uppfyller filtreringskriteriet.
                // Det ska returnera ett Optional-objekt som kan innehålla en uppgift eller vara tomt.
                .findFirst()

                //ToDo: Gör så att om en uppgift hittas (Optional är inte tom):
                // Omvandlas uppgiften till ett ResponseEntity med HTTP-status 200 OK och uppgiften som body.
                .map(ResponseEntity::ok)

                //ToDo: Gör så att Om ingen uppgift hittas (Optional är tom):
                // Skapas ett ResponseEntity med HTTP-status 404 Not Found och ingen body.
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Hämtar och söker uppgift genom id
     * @param id är id till uppgiften/task.
     * @return Status 200 om uppgiften matchade titel annars Status 404
     */

    @GetMapping("/{id}")//ToDo: Skapa en annotation för att hantera HTTP GET-förfrågningar för en specifik URL-väg. Vägparameter eller path variable är {id}.
    public ResponseEntity<Task> getTaskById(@PathVariable int id) { //ToDo: Skapa en wrapper (ResponseEntity<Task>) som retunerar både HTTP-status och eventuell en uppgift i body.
        //ToDo: Skapa en annotation med  @PathVariable. Den ska vara av typen String  ha variabelnamnet id. Detta binder URL-parameten {id} till metodargumentet id.
        return tasks.stream()//ToDo: Iterera över listan tasks för att möjliggöra filtrering, sökning och bearbetning av uppgifter.

                //ToDo: Filtrera strömmen för att hitta uppgifter där id matchar argumentet "id".
                .filter(task -> task.getId() == id)

                //ToDo: Skapa .findFirst() som  söker efter den första uppgiften som uppfyller filtreringskriteriet.
                // Det ska returnera ett Optional-objekt som kan innehålla en uppgift eller vara tomt.
                .findFirst()

                //ToDo: Gör så att om en uppgift hittas (Optional är inte tom):
                // Omvandlas uppgiften till ett ResponseEntity med HTTP-status 200 OK och uppgiften som body.
                .map(ResponseEntity::ok)

                //ToDo: Gör så att Om ingen uppgift hittas (Optional är tom):
                // Skapas ett ResponseEntity med HTTP-status 404 Not Found och ingen body.
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    /**
     * Lägger till en task i listan och status
     * @param task är objektnamnet för objekt som ska läggas till
     * @return är statuskoden 201 eller 400
     */
    @PostMapping//ToDo: Skapa en annotation som hanterare för HTTP POST-förfrågningar.
    //ToDo Skapa en metod (ResponseEntity) som innehållet Task-objekt. Den ska användas för att skicka både data och HTTP-statuskod.
    //ToDo: Skapa "RequestBody Task task vilket markerar att metoden väntar sig ett Task-objekt som skickas i begärans kropp i JSON-format. Spring mappar JSON-data från förfrågningen till ett Task-objekt automatiskt.
    public ResponseEntity<Task> addTask(@RequestBody Task task) {

        //ToDo: Skapa en if-sats som säger att om task-objektet inte är null och task.getId() är större än 0 (ett giltigt ID) och task.getTitle() och task.getDescription() inte är null (båda måste vara angivna).
        if (task != null && task.getId() > 0 && task.getTitle() != null && task.getDescription() != null) {
            tasks.add(task); //ToDo: Då ska tasken läggas till i listan
            return ResponseEntity.status(HttpStatus.CREATED).body(task); //ToDo: Retunera en HTTP 201 (Created)-statuskod för att signalera att en ny resurs har skapats. Inkludera det nyligen skapade Task-objektet i svaret.
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build(); //ToDo: Returnera bad request (HTTP 400) om något saknas
        }
    }

    /**
     * Uppdaterar en task i listan tasks baserat id och ny data som skickas från klient
     * @param id är id:et för uppgift
     * @param updatedTask är uppdaterade uppgiften
     * @return uppdaterad task och HTTP 200 eller 404 ID för task inte hittas
     */
    @PutMapping("/{id}")//ToDo: Skapa annotation som skapar HTTP PUT-förfrågningar.Skapa även en vägparameter (/{id}) som är ett unikt ID som skickas i URL:en.
    //ToDo: Skapa en metod som uppdaterar en befintlig uppgift baserat på dess ID och den nya informationen som skickas i förfrågningens kropp.
    // @PathVariable int id ska hämta  uppgiftens ID från URL:en. @RequestBody Task updatedTask ska  omvandla JSON-data från förfrågningens kropp till ett Task-objekt.
    public ResponseEntity<Task> updateTask(@PathVariable int id, @RequestBody Task updatedTask) {
        for (Task task : tasks) { //ToDo: Iterera över alla uppgifter i listan tasks.
            if (task.getId() == id) { //ToDo: Kontrollera om uppgiftens id  matchar det angivna id:et.
                task.setTitle(updatedTask.getTitle()); //ToDo: Sätt uppgiftens titel till det uppdaterade titeln.
                task.setDescription(updatedTask.getDescription());//ToDo: Sätt uppgiftens beskrivning till det uppdaterade beskrivningen.
                return ResponseEntity.ok(task);// ToDo: Metoden ska returnera ett ResponseEntity som innehåller den uppdaterade uppgiften och HTTP 200 (OK) om uppdateringen lyckas.
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();//ToDo: Annars ska HTTP 404 (NOT FOUND) retuneras då  uppgiften med det angivna ID:t inte hittas.

    }

    /**
     * Hanterar borttagning av en uppgift baserat på dess id
     * @param id är id:et till uppgiften som ska raderas
     * @return 200 och bekräftelsemeddelande om borttagning lyckades annars retuneras 404 med ett felmeddelande
     */
    @DeleteMapping("/{id}")// ToDo: Definiera en DELETE-HTTP-begäran där ID:et hämtas från URL:en.
    public ResponseEntity<String> deleteTask(@PathVariable int id) { //ToDo: Skapa ResponsEntity-objekt som representerar HTTP-svar. Typen av svarsdata ska vara en textsträng. @PathVariable ska binda URL-delen {id} till metodens id-parameter.
        boolean removed = false;
        //ToDo: Skapa en for-loop som itererar över tasks-listan för att hitta en uppgift med ett matchande ID.
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId() == id) { //ToDo: Om en match hittas tas uppgiften bort från listan och "removed" sätts till "true".
                tasks.remove(i);
                removed = true;
            }
        }
        if (removed) { //ToDo:  Om borttagningen lyckas returneras ett ResponseEntity med ett bekräftelsemeddelande och HTTP 200 (OK).
            return ResponseEntity.ok("Task with ID " + id + " has been deleted.");
        } else { //ToDo: Om ingen uppgift hittas med det angivna ID:et returneras ett ResponseEntity med ett felmeddelande och HTTP 404 (NOT FOUND).
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Task with ID " + id + " was not found.");
        }
    }

}

