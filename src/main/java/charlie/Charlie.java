package charlie;

/**
 * The main class that orchestrates the Charlie task manager.
 * It initializes storage, loads tasks, and processes user commands.
 */

public class Charlie {
    private final Storage storage;
    private TaskList taskList;

    public Charlie(String filePath) {
        this.storage = new Storage(filePath);
        this.taskList = new TaskList(storage);
    }

    public void run() {
        Ui.showWelcome();
        while (true) {
            try {
                String fullCommand = Ui.readCommand();
                Parser parser = new Parser(fullCommand);
                parser.action(taskList);
            } catch (Exception e) {
                Ui.showError(e.getMessage());
            }
        }
    }

    public String getResponse(String input) {
        String response = "";
        try {
            Parser parser = new Parser(input);
            response = parser.getResponse(taskList);
        } catch (Exception e) {
            response = Ui.showError(e.getMessage());
        }
        return response;
    }

}
