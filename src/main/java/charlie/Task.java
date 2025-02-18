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

    public Boolean matchWord(String word) {
        return this.activity.contains(word);
    }

    public int getMatchScore(String query) {
        int score = 0;
        // Split and convert to lower-case for case-insensitive comparisons.
        String[] queryWords = query.toLowerCase().split("\\s+");
        String[] activityWords = this.activity.toLowerCase().split("\\s+");

        for (String queryWord : queryWords) {
            score = getScore(queryWord, activityWords, score);
        }
        return score;
    }

    private int getScore(String queryWord, String[] activityWords, int score) {
        for (String activityWord : activityWords) {
            if (isFuzzyMatch(queryWord, activityWord)) {
                score++;
                break;
            }
        }
        return score;
    }

    private boolean isFuzzyMatch(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();

        // For words shorter than 4 letters, require an exact match.
        if (a.length() < 4 || b.length() < 4) {
            return a.equals(b);
        }

        return isMatch(a, b);
    }

    private boolean isMatch(String a, String b) {
        int i = 0, j = 0, diffCount = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                diffCount++;
                if (diffCount > 2) {
                    return false;
                }
                // If lengths are equal, treat this as a substitution.
                if (a.length() == b.length()) {
                    i++;
                    j++;
                } else if (a.length() > b.length()) {
                    i++;
                } else {
                    j++;
                }
            }
        }
        // Account for any remaining characters.
        diffCount += (a.length() - i) + (b.length() - j);
        return diffCount <= 2;
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
