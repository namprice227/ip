public class Deadline extends Task {
    private final String date;

    public Deadline(String task) {
        super(task.split("/by")[0]);
        System.out.println(task);
        date = task.split("/by")[1];
    }

    public Deadline(String task, String date, Boolean marked) {
        super(task, marked);
        System.out.println(task);
        this.date = date;
    }

    public String toString() {
        return "[D]" + super.toString() + "(by:" + date + ")";
    }

    public String writeToFile() {
        return "D" + super.writeToFile() +  " | " + date;
    }
}
