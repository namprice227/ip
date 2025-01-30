package charlie;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event extends Task {
    private final LocalDate startTime;
    private final LocalDate endTime;

    public Event(String task) {
        super(task.split("/from")[0]);
        startTime = LocalDate.parse(task.split("/from")[1].split("/to")[0].trim());
        endTime = LocalDate.parse(task.split("/to")[1].trim());
    }

    public Event(String task, String startTime, String endTime, Boolean marked) {
        super(task, marked);
        this.startTime = LocalDate.parse(startTime);
        this.endTime = LocalDate.parse(endTime);
    }

    public String toString() {
        return "[E]" + super.toString() + " (from: " + startTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + " to: " + endTime.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }

    public String writeToFile() {
        return "E" + super.writeToFile() + "|" + startTime + "|" + endTime + "\n";
    }
}
