import java.util.ArrayList;

class TaskList {
    private final ArrayList<Task> tasks;
    private final Storage storage;

    public TaskList(Storage storage) {
        this.storage = storage;
        this.tasks = storage.loadTasks();
    }

    public void addTask(Task task) {
        tasks.add(task);
        storage.saveTasks(tasks);
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    public void deleteTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            Task removedTask = tasks.remove(index - 1);
            storage.saveTasks(tasks);
            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println("Now you have " + tasks.size() + " tasks in the list.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void markTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).mark();
            storage.saveTasks(tasks);
            System.out.println("Nice! I've marked this task as done:");
            System.out.println(tasks.get(index - 1));
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void unmarkTask(int index) {
        if (index >= 1 && index <= tasks.size()) {
            tasks.get(index - 1).unmark();
            storage.saveTasks(tasks);
            System.out.println("OK, I've marked this task as not done yet:");
            System.out.println(tasks.get(index - 1));
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("There are no tasks, please feel free to add more");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
