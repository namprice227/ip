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

    /**
     * Validates a ToDo task description.
     * Ensures the task description is not empty.
     *
     * @param words The ToDo task description.
     * @return {@code true} if the description is valid, {@code false} otherwise.
     */
    public static boolean isValidTodo(String words) {
        if (words.isEmpty()) {
            System.out.println("Oh no! The description of a todo cannot be empty.");
            System.out.println("Usage: todo <task description>");
            return false;
        }
        return true;
    }

    /**
     * Validates a Deadline task description.
     * Ensures the description contains a deadline keyword (`/by`)
     * and that the date is in the correct format (YYYY-MM-DD).
     *
     * @param words The Deadline task description.
     * @return {@code true} if the description is valid, {@code false} otherwise.
     */

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

    /**
     * Validates an Event task description.
     * Ensures the description contains both `/from` and `/to` keywords
     * and that both dates are in the correct format (YYYY-MM-DD).
     *
     * @param words The Event task description.
     * @return {@code true} if the description is valid, {@code false} otherwise.
     */

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

    /**
     * Validates if the given string is a valid integer.
     * Ensures that the input can be parsed into an integer.
     *
     * @param number The string representing the task number.
     * @return {@code true} if the input is a valid integer, {@code false} otherwise.
     */
    
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
