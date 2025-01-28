import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import static java.lang.System.exit;

public class Charlie {

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        File folder = new File("./data"); // Reference to the "data" folder
        File file = new File(folder, "charlie.txt"); // File within the folder

        try {
            // Check if the folder exists
            if (!folder.exists()) {
                // Create the folder
                if (!folder.mkdirs()) {
                    System.out.println("Failed to create folder 'data'.");
                    return; // Exit if the folder creation fails
                }
            }

            // Check if the file exists
            if (file.exists()) {
                System.out.println("File already exists. Reading contents:");

                // Read the file
                Scanner reader = new Scanner(file);
                while (reader.hasNextLine()) {
                    String line = reader.nextLine();
                    tasks.add(Task.addFromFile(line));
                }
                reader.close();
            } else {
                // Create the file
                if (!file.createNewFile()) {
                    System.out.println("Failed to create file 'charlie.txt'.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        System.out.println("Hello! I'm Charlie");
        System.out.println("What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Please tell me what to do");
            }
            String[] words = input.split(" ", 2);
            if (input.equals("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i).toString());
                }
                if (tasks.isEmpty()) {
                    System.out.println("There are no tasks, please feel free to add more");
                }
            }

            else if (input.equals("bye")) {
                break;
            }
            else {
                switch (words[0]) {
                    case "mark" -> {
                        if (CharlieHandler.isValidNumber(words)) {
                            int index = Integer.parseInt(words[1]) - 1;
                            tasks.get(index).mark();
                            System.out.println("Nice, I have marked your task:");
                            System.out.println(tasks.get(index).toString());
                        }
                    }
                    case "unmark" -> {
                        if (CharlieHandler.isValidNumber(words)) {
                            int index = Integer.parseInt(words[1]) - 1;
                            tasks.get(index).unmark();
                            System.out.println("I have unmarked your task:");
                            System.out.println(tasks.get(index).toString());
                        }
                    }
                    case "todo" -> {
                        if (CharlieHandler.isValidTodo(words)) {
                            Task task = new Todo(words[1]);
                            tasks.add(task);
                            System.out.println("Got it, I have added the task:");
                            System.out.println(task);
                            System.out.println("Now, you have " + tasks.size() + " tasks");
                        }
                    }
                    case "deadline" -> {
                        if (CharlieHandler.isValidDeadline(words)) {
                            Task task = new Deadline(words[1]);
                            tasks.add(task);
                            System.out.println("Got it, I have added the task:");
                            System.out.println(task);
                            System.out.println("Now, you have " + tasks.size() + " tasks");
                        }
                    }
                    case "event" -> {
                        if (CharlieHandler.isValidEvent(words)) {
                            Task task = new Event(words[1]);
                            tasks.add(task);
                            System.out.println("Got it, I have added the task:");
                            System.out.println(task);
                            System.out.println("Now, you have " + tasks.size() + " tasks");
                        }
                    }
                    case "delete" -> {
                        if (CharlieHandler.isValidNumber(words)) {
                            int index = Integer.parseInt(words[1]) - 1;
                            Task task = tasks.get(index);
                            tasks.remove(index);
                            System.out.println("Got it, I have removed the task:");
                            System.out.println(task);
                            System.out.println("Now, you have " + tasks.size() + " tasks");
                        }
                    }
                    default -> CharlieHandler.printHelp();
                }
            }
        }
        System.out.println("Goodbye! Hope to see you soon!");
    }
}
