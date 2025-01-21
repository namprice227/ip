public class Deadline extends Task {
    private final String date;

    public Deadline(String task) {
        super(task.split("/by")[0]);
        System.out.println(task);
        date = task.split("/by")[1];
    }

    public String toString() {
        return "[D]" + super.toString() + "(by:" + date + ")";
    }
}
