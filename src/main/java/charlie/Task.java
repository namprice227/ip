package charlie;

public class Task {
    private final String activity;
    private Boolean marked;

    Task(String activity) {
        this.activity = activity;
        this.marked = false;
    }

    Task(String activity, Boolean marked) {
        this.activity = activity;
        this.marked = marked;
    }

    public void mark() {
        this.marked = true;
    }

    public void unmark() {
        this.marked = false;
    }

    protected Boolean getMarked() {
        return this.marked;
    }

    public String writeToFile() {
        int ismarked = 0;
        if (this.marked) {
            ismarked = 1;
        }
        return "|" + ismarked + "|" + this.activity;
    }

    static public Task addFromFile(String line) {
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
        }
        return new Task(parts[0]);
    }

    public String toString() {
        if (marked) {
            return "[X] " + activity.trim();
        } else {
            return "[ ] " + activity.trim();
        }
    }
}
