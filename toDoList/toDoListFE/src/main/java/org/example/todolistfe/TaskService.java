package org.example.todolistfe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.todolistfe.interfaces.InterfaceController;
import org.example.todolistfe.interfaces.InterfaceService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Comparator;

/**
 * I klassem finns metoder för att hämta alla uppgifter, lägga till en uppgift, ta bort en uppgift beroende på id:et, prioritera uppgifter och hämta genom id:et.
 *
 * @author Maryam Rasouli
 * @version 1.0
 * @since 2024-12-20
 * @see InterfaceController,InterfaceService,Task,TaskApplication,TaskController
 */

public class TaskService implements InterfaceService {//ToDo: Implementera  interfacet  InterfaceService med kontrakt för metoder.

    //ToDo: Använd ObjectMapper för att hantera konvertering.
    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Hämtar alla uppgifter från backend
     * @return uppgifterna som är formatterade.
     * @throws Exception om något går fel kastas ett undantag och måste hanteras från metoden den anropas ifrån.
     */
    public String getAllTasks() throws Exception {
        // ToDo:Hämta alla uppgifter från backend
        URL url = new URL("http://localhost:8080/api/tasks");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        //ToDo: Läs svaret från servern
        String response = readResponse(connection);

        //ToDo: Konvertera svaret till en lista av Task-objekt
        Task[] tasks = mapper.readValue(response, Task[].class);

        //ToDo: Sortera uppgifterna efter ID
        Arrays.sort(tasks, Comparator.comparingInt(Task::getId));

        //ToDo: Bygg en formaterad sträng med uppgifterna och styckeindelning
        StringBuilder formattedTasks = new StringBuilder();
        for (Task task : tasks) { //ToDo: Loopa igenom alla uppgifterna så att de blir formatterade.
            formattedTasks.append(String.format("%d. %s: %s%n%n", task.getId(), task.getTitle(), task.getDescription()));
        }
        return formattedTasks.toString().trim(); //ToDo: Trimma sista radbrytningen
    }

    /**
     * Lägger till en ny uppgift genom POST-begäran till backend.
     * @param id id:et till uppgiften
     * @param title titeln till uppgiften
     * @param description beskrivningen till uppgiften
     * @return svaret från servern
     * @throws Exception om något går fel kastas ett undatag och måste hanteras från metoden den anropas ifrån.
     */
    //ToDo: Lägg till en ny uppgift genom att skicka en POST-begäran till backend.
    public String addNewTask(int id, String title, String description) throws Exception {
        //ToDo: Skapa en ny Task-instans
        Task task = new Task(id, title, description);

        //ToDo: Konvertera Task-objektet till JSON
        String json = mapper.writeValueAsString(task);

        //ToDo: Skicka en POST-begäran till backend.
        URL url = new URL("http://localhost:8080/api/tasks");//ToDo: Skapa en URL till backendens API för uppgifter.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();//ToDo: Öppna en HTTP-anslutning till den angivna URL:en.
        connection.setRequestMethod("POST");//ToDo: Sätt HTTP-metoden till POST, som används för att skicka data.
        connection.setRequestProperty("Content-Type", "application/json");//ToDo: Sätt rätt Content-Type för att skicka JSON-data.
        connection.setDoOutput(true);//ToDo:Tillåt data att skickas som en del av begäran (i POST-metoden).

        // ToDo: Skicka JSON-data som en del av POST-begäran till backend.
        try (OutputStream os = connection.getOutputStream()) {//ToDo: Öppna en OutputStream för att skicka data till servern.
            os.write(json.getBytes(StandardCharsets.UTF_8));//ToDo: Skriv JSON-strängen som byte-array i UTF-8-format till OutputStream.
        }

        //ToDo: Läs och returnera svaret från servern.
        return readResponse(connection);
    }

    /**
     * Tar bort en uppgift baserat på id:et.
     * @param id id:et för uppgiften som ska raderas
     * @return svaret från servern
     * @throws Exception om något går fel kastas ett undatag och måste hanteras från metoden den anropas ifrån.
     */
    public String deleteTaskById(int id) throws Exception {
        // ToDo: Skicka en DELETE-begäran till backend för att ta bort en uppgift baserat på ID.
        URL url = new URL("http://localhost:8080/api/tasks/" + id); //ToDo: Skapa URL med ID för att identifiera uppgiften som ska tas bort.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();//ToDo: Öppna en anslutning till den angivna URL:en.
        connection.setRequestMethod("DELETE");//ToDo: Ställ in RequestMethod till DELETE.

        //ToDo: Läs och returnera svaret från servern och retunera det som en sträng.
        return readResponse(connection);
    }

    /**
     * Prioritera uppgift genom att lägga (!) framför id:et.
     * @param id är id:et för uppgiften
     * @param tasks är uppgiften
     * @return uppdaterad lista med prioritering eller om uppgiften inte hittades(null).
     */
    //ToDo: Prioritera en uppgift genom att lägga till (!) framför dess ID
    public String prioritizeTaskById(int id, String tasks) {
        String[] taskList = tasks.split("\n");//ToDo: Dela upp den mottagna uppgiftssträngen i en lista baserat på radbrytningar.
        StringBuilder updatedTasks = new StringBuilder();//ToDo: Skapa en StringBuilder för att bygga den uppdaterade listan med uppgifter.
        boolean taskFound = false;//ToDo: Skapa en variabel för att spåra om den angivna uppgiften hittas.

        for (String task : taskList) {
            // ToDo: Om uppgiften börjar med det angivna ID:t, prioritera den genom att lägga till "(!)" framför ID:t.
            if (task.startsWith(id + ".")) {
                updatedTasks.append(task.replaceFirst("^" + id + "\\.", "(!) " + id + ".")).append("\n");
                taskFound = true;
            } else {
                updatedTasks.append(task).append("\n"); // ToDo: Annars är det inte rätt uppgift, lägg till den som den är.
            }
        }
        //ToDo: Om uppgiften inte hittades kasta ett undantag.
        if (!taskFound) throw new IllegalArgumentException("Task ID not found: " + id);

        return updatedTasks.toString().trim(); // ToDo: Returnera den uppdaterade listan som en sträng, utan extra radbrytningar i slutet.
    }

    /**
     * Hämta uppgift genom id:et.
     * @param id är id:et för uppgiften
     * @return konverterat JSON-svar till ett Task-objekt.
     * @throws Exception om något går fel kastas ett undatag och måste hanteras från metoden den anropas ifrån.
     */
    //ToDo: Hämta en specifik uppgift baserat på dess ID.
    public Task getTaskById(int id) throws Exception {
        URL url = new URL("http://localhost:8080/api/tasks/" + id); //ToDo: Skapa en URL för att hämta en specifik uppgift baserat på ID från backend.
        HttpURLConnection connection = (HttpURLConnection) url.openConnection(); //ToDo: Öppna en HTTP-anslutning till den skapande URL:en.
        connection.setRequestMethod("GET");//ToDo: Ställ in begäran som GET (för att hämta data från servern)

        // ToDo: Läs svaret från servern genom att anropa hjälpfunktionen readResponse.
        String response = readResponse(connection);
        //ToDo: Om svaret innehåller "not found", returnera null eftersom uppgiften inte hittades
        if (response.contains("not found")) return null;

        //ToDo: Konvertera JSON-svaret till ett Task-objekt med hjälp av Jackson (ObjectMapper)
        return mapper.readValue(response, Task.class);
    }

    /**
     * Hjälpmetod för att läsa och returnera serverns svar som en sträng.
     * @param connection objekt av typen HttpURLConnection som representerar öppet HTTP-anslutning mellan klienten och server.
     * @return svaret från servern
     * @throws Exception om något går fel kastas ett undatag och måste hanteras från metoden den anropas ifrån.
     */
    //ToDo: Skapa en hjälpmetod för att läsa och returnera serverns svar som en sträng
    private String readResponse(HttpURLConnection connection) throws Exception {
        //ToDo: Skapa en BufferedReader för att läsa svaret från servern
        // Om statuskoden är under 300 (vilket innebär att begäran lyckades) läses svaret från InputStream.
        // Annars läses felmeddelandet från ErrorStream.

        BufferedReader reader = new BufferedReader(new InputStreamReader(
                connection.getResponseCode() < 300 ? connection.getInputStream() : connection.getErrorStream()
        ));

        //ToDo: Använd StringBuilder för att bygga upp hela svaret som en sträng.
        StringBuilder response = new StringBuilder();
        String line;

        //ToDo: Läs varje rad i svaret och lägg till den i response
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        //ToDo: Stäng BufferedReader när vi är klara med att läsa
        reader.close();

        //ToDo: Returnera hela svaret som en sträng
        return response.toString();
    }
}
