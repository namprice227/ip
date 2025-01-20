public class Task {
    private final String activity;
    private Boolean marked;
    Task(String activity) {
        this.activity = activity;
        this.marked = false;
    }
    public void mark() {
        this.marked = true;
    }

    public void unmark() {
        this.marked = false;
    }

    public String toString() {
        if (marked) {
            return "[x] " + activity;
        }
        else {
            return "[ ] " + activity;
        }
    }
}
