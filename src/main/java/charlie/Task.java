package charlie;

/**
 * The Task class represents a general task with an activity description and a marked status.
 * Subclasses may extend this class to represent specific types of tasks (e.g., Todo, Deadline, Event).
 */
public class Task {
    private final String activity;
    private Boolean marked;

    Task(String activity) {
        assert activity != null : "Activity must not be null";
        this.activity = activity;
        this.marked = false;
    }

    Task(String activity, Boolean marked) {
        assert activity != null : "Activity must not be null";
        assert marked != null : "Marked flag must not be null";
        this.activity = activity;
        this.marked = marked;
    }

    /**
     * Marks the task as completed.
     */
    public void mark() {
        this.marked = true;
    }

    /**
     * Unmarks the task, setting its status back to incomplete.
     */
    public void unmark() {
        this.marked = false;
    }

    /**
     * Returns a string representation of the task that can be written to a file.
     * The format includes the marked status and the task description.
     *
     * @return A string representing the task in file-save format.
     */
    public String writeToFile() {
        int ismarked = 0;
        if (this.marked) {
            ismarked = 1;
        }
        return "|" + ismarked + "|" + this.activity;
    }

    public Boolean containsWord(String word) {
        return this.activity.contains(word);
    }

    /**
     * Creates a Task object from a string representation loaded from a file.
     * The string is split into parts based on the file format and a specific task type is created accordingly.
     *
     * @param line A string representing a task from a file.
     * @return A Task object based on the information in the line.
     */
    public static Task addFromFile(String line) {
        String[] parts = line.split("\\|");
        switch (parts[0]) {
        case "T" -> {
            if (parts[1].equals("1")) {
                return new Todo(parts[2], true);
            } else {
                return new Todo(parts[2]);
            }
        }
        case "D" -> {
            if (parts[1].equals("1")) {
                return new Deadline(parts[2], parts[3], true);
            } else {
                return new Deadline(parts[2], parts[3], false);
            }
        }
        case "E" -> {
            if (parts[1].equals("1")) {
                return new Event(parts[2], parts[3], parts[4], true);
            } else {
                return new Event(parts[2], parts[3], parts[4], false);
            }
        }
        default -> {
            return new Task(parts[0]);
        }
        }
    }

    public String toString() {
        if (marked) {
            return "[X] " + activity.trim();
        } else {
            return "[ ] " + activity.trim();
        }
    }
}
