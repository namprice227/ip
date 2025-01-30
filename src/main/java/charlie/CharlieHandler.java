package charlie;

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

    public static boolean isValidTodo(String words) {
        if (words.isEmpty()) {
            System.out.println("Oh no! The description of a todo cannot be empty.");
            System.out.println("Usage: todo <task description>");
            return false;
        }
        return true;
    }

    public static boolean isValidDeadline(String words) {
        if (!words.contains("/by")) {
            System.out.println("Oh no! The description of a deadline cannot be empty.");
            System.out.println("Usage: deadline <task description> /by <time>");
            return false;
        }
        if (!isValidDate(words.split("/by")[1])) {
            System.out.println("Oh no! your date needs to be in the format YYYY-MM-DD");
            System.out.println("Usage: deadline <task description> /by <time>");
            return false;
        }
        return true;
    }

    public static boolean isValidEvent(String words) {
        if (!words.contains("/from") || !words.contains("/to")) {
            System.out.println("Oh no! The description of an event cannot be empty.");
            System.out.println("Usage: event <event description> /from <start time> /to <end time>");
            return false;
        }
        if (!isValidDate(words.split("/from")[1].split("/to")[0]) && !isValidDate(words.split("/from")[1].split("/to")[1])) {
            System.out.println("Oh no! your date needs to be in the format YYYY-MM-DD");
            System.out.println("Usage: event <event description> /from <start time> /to <end time>");
            return false;
        }
        return true;
    }

    public static boolean isValidNumber(String number) {
        try {
            Integer.parseInt(number.trim());
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Oh no! The task number should be a valid integer.");
            return false;
        }
    }
}
