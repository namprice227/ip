import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Deadline extends Task {
    private final LocalDate date;

    public Deadline(String task) {
        super(task.split("/by")[0]);
        date = LocalDate.parse(task.split("/by")[1].trim());
    }

    public Deadline(String task, String date, Boolean marked) {
        super(task, marked);
        this.date = LocalDate.parse(date);
    }

    public String toString() {
        return "[D]" + super.toString() + "(by:" + date.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    public String writeToFile() {
        try {
            return "D" + super.writeToFile() + "|" + date.toString() + "\n";
        } catch (Exception e) {
            System.out.println(date);
        }
        return "D" + super.writeToFile() + "|" + date.toString() + "\n";
    }
}
