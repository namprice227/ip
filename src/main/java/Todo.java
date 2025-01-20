public class Todo extends Task{
    public Todo(String activity) {
        super(activity);
    }
    public String toString() {
        return "[T]" + super.toString();
    }
}
