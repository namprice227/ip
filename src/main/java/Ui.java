import java.io.File;
import java.io.IOException;
import java.util.Scanner;

class Ui {
    public static void showWelcome() {
        System.out.println("Hello! I'm Charlie");
        System.out.println("What can I do for you?");
    }


    public static String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static void printHelp() {
        System.out.println("Here are the commands you can use:");
        System.out.println("1. todo <task description>");
        System.out.println("2. deadline <task description> /by <time>");
        System.out.println("3. event <event description> /from <start time> /to <end time>");
        System.out.println("4. delete <task number>");
        System.out.println("5. list");
        System.out.println("6. bye");
    }

    public static void showGoodbye() {
        System.out.println("Goodbye! Hope to see you soon!");
    }

    public static void showError(String message) {
        System.out.println("Error: " + message);
    }
}