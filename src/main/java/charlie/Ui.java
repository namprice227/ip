package charlie;

import java.util.Scanner;

/**
 * Represents the user interface for interacting with the task manager.
 * This class handles displaying messages to the user and reading input from the user.
 */
class Ui {
    /**
     * Displays a welcome message when the application starts.
     */
    public static void showWelcome() {
        System.out.println("Hello! I'm charlie.Charlie");
        System.out.println("What can I do for you?");
    }

    /**
     * Reads a command input from the user.
     *
     * @return The command input by the user as a String.
     */
    public static String readCommand() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Prints a help message that shows the available commands the user can use.
     */
    public static void printHelp() {
        System.out.println("Here are the commands you can use:");
        System.out.println("1. todo <task description>");
        System.out.println("2. deadline <task description> /by <time>");
        System.out.println("3. event <event description> /from <start time> /to <end time>");
        System.out.println("4. delete <task number>");
        System.out.println("5. list");
        System.out.println("6. bye");
    }

    /**
     * Displays a goodbye message when the user exits the application.
     */
    public static void showGoodbye() {
        System.out.println("Goodbye! Hope to see you soon!");
    }

    public static void showError(String message) {
        System.out.println("Error: " + message);
    }
}