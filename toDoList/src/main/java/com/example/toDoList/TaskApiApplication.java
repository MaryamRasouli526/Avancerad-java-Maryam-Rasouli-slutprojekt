package com.example.toDoList;

import com.example.toDoList.controllers.TaskController;
import com.example.toDoList.models.Task;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Klassen är till för kunna köra mitt program med Sring Boot. Men även för att starta backend.
 *
 * @author Maryam Rasoui
 * @version 1.0
 * @since 2024-12-20
 * @see TaskController,Task
 */

@SpringBootApplication
public class TaskApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskApiApplication.class, args);
	}

}
