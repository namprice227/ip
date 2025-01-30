package charlie;

import static java.lang.Integer.parseInt;
import static java.lang.System.exit;

/**
 * The Parser class is responsible for interpreting user input commands and performing actions
 * on the TaskList. It handles various actions like marking tasks, adding tasks, listing tasks, etc.
 */
class Parser {
    private String action;
    private String task;

    Parser(String input) {
        try {
            String[] words = input.split(" ", 2);
            this.action = words[0];
            this.task = words[1];
        } catch (Exception e) {
            String[] words = input.split(" ", 2);
            this.action = words[0];
            this.task = "";
        }
    }

    /**
     * Executes the corresponding action based on the parsed input.
     * The action is matched to a specific command and then the corresponding method of the TaskList is called.
     *
     * @param taskList The task list on which the action should be performed.
     */
    public void action(TaskList taskList) {
        switch (this.action) {
            case "" -> {
                System.out.println("Please tell me what to do");
                Ui.printHelp();
            }
            case "list" -> {
                taskList.listTasks();
            }
            case "mark" -> {
                if (CharlieHandler.isValidNumber(task)) {
                    taskList.markTask(parseInt(task));
                }
            }
            case "unmark" -> {
                if (CharlieHandler.isValidNumber(task)) {
                    taskList.unmarkTask(parseInt(task));
                }
            }
            case "todo" -> {
                if (CharlieHandler.isValidTodo(task)) {
                    taskList.addTask(new Todo(task));
                }
            }
            case "deadline" -> {
                if (CharlieHandler.isValidDeadline(task)) {
                    taskList.addTask(new Deadline(task));
                }
            }
            case "event" -> {
                if (CharlieHandler.isValidEvent(task)) {
                    taskList.addTask(new Event(task));
                }
            }
            case "delete" -> {
                if (CharlieHandler.isValidNumber(task)) {
                    taskList.deleteTask(parseInt(task));
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


