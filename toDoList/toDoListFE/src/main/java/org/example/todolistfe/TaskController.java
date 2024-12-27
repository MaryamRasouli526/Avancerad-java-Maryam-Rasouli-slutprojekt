package org.example.todolistfe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.example.todolistfe.interfaces.InterfaceController;
import org.example.todolistfe.interfaces.InterfaceService;

/**
 * Klassen består av metoder sker beroende på vilken knapp i programmet man klickar på.
 * <p>
 * Det finns metoder för att hämta alla uppgifter, lägga till en uppgift, ta bort en uppgift beroende på id:et, tömma textfälten, prioritera uppgifter och ladda uppgifter för att redigera dem.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @see InterfaceService,InterfaceController,Task,TaskApplication,TaskService
 * @since 2024-12-20
 */

public class TaskController implements InterfaceController { //ToDo:  Implementera  interfacet  InterfaceController med kontrakt för metoder.

    @FXML
    private TextField input_taskId; //ToDo: Lägg till textfält för att skriva in id:et i mitt fönster som privat attribut.

    @FXML
    private TextField Input_taskIDToDeleteOrEdit; //ToDo: Lägg till textfält för att skriva in id:et, för redigering eller borttagning, i mitt fönster som privat attribut.

    @FXML
    private TextArea input_taskDescription; //ToDo: Lägg till textArea för att skriva in beskrivningen i mitt fönster som privat attribut.

    @FXML
    private TextField input_taskIdIfImportant; //ToDo: Lägg till textfält för att skriva in id:et i mitt fönster, om uppgiften ska prioriteras, som privat attribut.

    @FXML
    private TextField input_taskTitle; //ToDo: Lägg till textfält för att skriva in titeln för uppgifter i mitt fönster som privat attribut.

    @FXML
    private Label label_showEditOrDelete; //ToDo: Lägg till en label för att visa  meddelanden i mitt fönster som privat attribut.

    @FXML
    private TextArea textArea_allTasks;//ToDo: Lägg till en textArea för att visa alla uppgifter som en privat attribut.

    //ToDo: Skapa en instans av TaskService för att hantera API-anrop och logik
    private final TaskService taskService = new TaskService();

    /**
     * Hämtar alla uppgifter för att visa dem i textArean.
     *
     * @param event är tryckningen av knappen "Add"
     */
    //ToDo: Lägg till en metod för att hämta alla uppgifter från API och visa dem i textArea_allTasks
    @FXML
    public void getAllTasks(ActionEvent event) {
        try { //ToDo: Försök at hämta och via uppgifterna i textArean.
            //ToDo: Hämta alla uppgifter från service-klassen.
            String tasks = taskService.getAllTasks();
            textArea_allTasks.setText(tasks); // ToDo: Visa uppgifterna i TextArea genom att använda setText.
        } catch (Exception e) { //ToDo: Fånga alla typer av fel och skriv sedan ett meddelande om felet i textArean.
            textArea_allTasks.setText("Error fetching tasks: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Lägger till en uppgift baserat på vad användaren skriver in för id,titel och beskrivning
     *
     * @param event tryckningen av knappen "Add".
     */
    //ToDo: Lägg till en ny uppgift baserat på användarens input
    @FXML
    public void addNewTask(ActionEvent event) {
        try {//ToDo: Försök hämta data från användarens inputfält
            int taskID = Integer.parseInt(input_taskId.getText()); //ToDo: Hämta och gör om id strängen till en int
            String title = input_taskTitle.getText();// ToDo: Spara texten för titel i en variabel.
            String description = input_taskDescription.getText();// ToDo: Spara texten för description i en variabel.

            // ToDo: Kontrollera att ID, title och description  är tomma eller ogiltiga
            if (title.isEmpty() || description.isEmpty() || taskID <= 0) {
                //ToDo: Då ska det stå i textArean ett meddelande om att de ska vara giltiga och sen ska man ut ur metoden genom return.
                textArea_allTasks.setText("ID, Title, and Description cannot be empty or invalid!");
                return;
            }

            //ToDo: Lägg till en ny uppgift genom service-klassen och visa svaret
            String response = taskService.addNewTask(taskID, title, description);
            textArea_allTasks.appendText(response);

            //ToDo: Uppdatera listan över alla uppgifter efter att en ny har lagts till
            getAllTasks(event);
        } catch (Exception e) { //ToDo: Fånga generella fel och få upp ett felmeddelande i textArean.
            textArea_allTasks.setText("Error adding task: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Tar bort uppgiften beroende på id:et.
     *
     * @param event tryckningen av knappen "Delete"
     */
    //ToDo: Ta bort en uppgift baserat på ID som användaren anger
    @FXML
    public void deleteTaskById(ActionEvent event) {
        try {//ToDo: Försök med ta bort uppgiften

            //ToDo: Hämta uppgiftens ID från användarens input.
            int taskId = Integer.parseInt(Input_taskIDToDeleteOrEdit.getText());

            //ToDo: Ta bort uppgiften genom service-klassen och visa svaret.
            String response = taskService.deleteTaskById(taskId);
            label_showEditOrDelete.setText(response);

            //ToDo: Uppdatera listan över alla uppgifter efter borttagning
            getAllTasks(event);
        } catch (Exception e) { //ToDo: Fånga generella fel och få upp ett felmeddelande i label.
            label_showEditOrDelete.setText("Error deleting task: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Tömmer alla input-fält
     *
     * @param event tryckning av knappen "Clear"
     */
    //ToDo: Töm alla input-fält.
    @FXML
    public void clearFields(ActionEvent event) {
        //ToDo: Rensa innehållet i alla input-fält (id, title och description).
        input_taskId.clear();
        input_taskTitle.clear();
        input_taskDescription.clear();

        //ToDo: Visa en bekräftelse på att fälten har rensats.
        label_showEditOrDelete.setText("Fields cleared successfully.");
    }

    /**
     * Prioriterar en uppgift baserat på id och visar bekräftelsemeddelande.
     *
     * @param event tryckningen av knappen "Select it".
     */
    // ToDo: Prioritera en uppgift baserat på dess ID.
    @FXML
    public void prioritizeTaskById(ActionEvent event) {
        try {//ToDo: Försök hämta id, uppdatera listan med ny id och visa bekräftelsemeddelande.
            //ToDo: Hämta ID för uppgiften som ska prioriteras.
            int taskId = Integer.parseInt(input_taskIdIfImportant.getText());

            //ToDo: Uppdatera listan med prioriterad uppgift.
            String updatedTasks = taskService.prioritizeTaskById(taskId, textArea_allTasks.getText());
            textArea_allTasks.setText(updatedTasks);

            //ToDo Visa en bekräftelse på prioriteringen
            label_showEditOrDelete.setText("Task prioritized: " + taskId);
        } catch (Exception e) { //ToDo: Fånga generella fel och skriv felmeddelande.
            label_showEditOrDelete.setText("Error prioritizing task: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Laddar uppgift som ska redigeras.
     *
     * @param event tryckning av knappen "Load edit"
     */
    //ToDo: Hämta en specifik uppgift för redigering baserat på dess ID.
    @FXML
    public void loadTaskForEditing(ActionEvent event) {
        try { //ToDO: Försök att rensa fälten, hämta id för uppgift som sak redigeras och hämta uppgiften från service-klassen.
            //ToDo: Rensa input-fälten för att börja om med redigering.
            input_taskId.clear();
            input_taskTitle.clear();
            input_taskDescription.clear();

            //ToDo: Hämta ID för den uppgift som ska laddas.
            int taskId = Integer.parseInt(Input_taskIDToDeleteOrEdit.getText());

            //ToDo: Hämta uppgiften från service-klassen.
            Task task = taskService.getTaskById(taskId);
            if (task != null) { // ToDo skapa in if-sats som kontrollerar att uppgiften innehåller något.
                //ToDo: Fyll då i textfälten med uppgiftens data.
                input_taskId.setText(String.valueOf(task.getId()));
                input_taskTitle.setText(task.getTitle());
                input_taskDescription.setText(task.getDescription());
            } else { //ToDo: Annars: Visa ett meddelande om att uppgiften inte hittades.
                label_showEditOrDelete.setText("Task not found.");
            }
        } catch (Exception e) { //ToDo: Fånga generella fel och skriv felmeddelande.
            label_showEditOrDelete.setText("Error loading task: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
