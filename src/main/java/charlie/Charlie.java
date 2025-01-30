package charlie;


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

}
