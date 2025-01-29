import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

class Parser {
    private final String action;
    private final String task;

    Parser (String input) {
        String[] words = input.split(" ", 2);
        this.action = words[0];
        this.task = words[1];
    }

    public void action(TaskList tasklist) {
        switch (this.action) {
            case "" -> {
                System.out.println("Please tell me what to do");
                Ui.printHelp();
            }
            case "list" -> {
                tasklist.listTasks();
            }
            case "mark" -> {
                if (CharlieHandler.isValidNumber(task)) {
                    tasklist.markTask(parseInt(task));
                }
            }
            case "unmark" -> {
                if (CharlieHandler.isValidNumber(task)) {
                    tasklist.unmarkTask(parseInt(task));
                }
            }
            case "todo" -> {
                if (CharlieHandler.isValidTodo(task)) {
                    tasklist.addTask(new Todo(task));
                }
            }
            case "deadline" -> {
                if (CharlieHandler.isValidDeadline(task)) {
                    tasklist.addTask(new Deadline(task));
                }
            }
            case "event" -> {
                if (CharlieHandler.isValidEvent(task)) {
                    tasklist.addTask(new Event(task));
                }
            }
            case "delete" -> {
                if (CharlieHandler.isValidNumber(task)) {
                    tasklist.deleteTask(parseInt(task));
                }
            }
            case "bye" -> {
                Ui.showGoodbye();
                exit(0);
            }
            default -> Ui.printHelp();
        }
    }
}


