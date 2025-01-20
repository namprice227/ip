public class Event extends Task {
    private final String startTime;
    private final String endTime;
    public Event(String task) {
        super(task.split("/from")[0]);
        startTime = task.split("/from")[1].split("/to")[0];
        endTime = task.split("/to")[1];
    }

    public String toString() {
        return "[E]" +super.toString() + "(from:" + startTime + "to:" + endTime + ")";
    }
}
