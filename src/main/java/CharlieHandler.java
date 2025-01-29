import java.time.LocalDate;

public class CharlieHandler {
    private static boolean isValidDate(String date) {
        try {
            LocalDate.parse(date.trim());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isValidTodo(String[] words) {
        if (words.length < 2 || words[1].isEmpty()) {
            System.out.println("Oh no! The description of a todo cannot be empty.");
            System.out.println("Usage: todo <task description>");
            return false;
        }
        return true;
    }

    public static boolean isValidDeadline(String[] words) {
        if (words.length < 2 || words[1].isEmpty() || !words[1].contains("/by")) {
            System.out.println("Oh no! The description of a deadline cannot be empty.");
            System.out.println("Usage: deadline <task description> /by <time>");
            return false;
        }
        if (!isValidDate(words[1].split("/by")[1])) {
            System.out.println("Oh no! your date needs to be in the format YYYY-MM-DD");
            System.out.println("Usage: deadline <task description> /by <time>");
            return false;
        }
        return true;
    }

    public static boolean isValidEvent(String[] words) {
        if (words.length < 2 || words[1].isEmpty() || !words[1].contains("/from") || !words[1].contains("/to")) {
            System.out.println("Oh no! The description of an event cannot be empty.");
            System.out.println("Usage: event <event description> /from <start time> /to <end time>");
            return false;
        }
        if (!isValidDate(words[1].split("/from")[1].split("/to")[0]) && !isValidDate(words[1].split("/from")[1].split("/to")[1])) {
            System.out.println("Oh no! your date needs to be in the format YYYY-MM-DD");
            System.out.println("Usage: event <event description> /from <start time> /to <end time>");
            return false;
        }
        return true;
    }

    public static boolean isValidNumber(String[] words) {
        try {
            Integer.parseInt(words[1]);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Oh no! The task number should be a valid integer.");
            return false;
        }
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
}
