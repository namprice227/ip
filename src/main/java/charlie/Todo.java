package charlie;

public class Todo extends Task {
    public Todo(String activity) {
        super(activity);
    }

    public Todo(String activity, Boolean marked) {
        super(activity, marked);
    }

    public String toString() {
        return "[T]" + super.toString();
    }

    public String writeToFile() {
        return "T" + super.writeToFile() + "\n";
    }
}
