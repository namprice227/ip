import java.util.ArrayList;
import java.util.Scanner;

public class Charlie {

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
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
            }

            else if (input.equals("bye")) {
                break;
            }
            else {
                switch (words[0]) {
                    case "mark" -> {
                        if (CharlieHandler.isValidMark(words)) {
                            int index = Integer.parseInt(words[1]) - 1;
                            tasks.get(index).mark();
                            System.out.println("Nice, I have marked your task:");
                            System.out.println(tasks.get(index).toString());
                        }
                    }
                    case "unmark" -> {
                        if (CharlieHandler.isValidMark(words)) {
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
                    default -> CharlieHandler.printHelp();
                }
            }
        }
        System.out.println("Goodbye! Hope to see you soon!");
    }
}
