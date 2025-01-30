package charlie;

import java.util.ArrayList;

/**
 * Represents a list of tasks that can be added, deleted, marked, unmarked, and listed.
 * This class manages tasks by interacting with the Storage class to persist data in a file.
 */
class TaskList {
    private final ArrayList<Task> tasks;
    private final Storage storage;

    public TaskList(Storage storage) {
        this.storage = storage;
        this.tasks = storage.loadTasks();
    }

    /**
     * Adds a new task to the list and saves the updated list to the storage file.
     *
     * @param task The task to be added to the list.
     */
    public void addTask(Task task) {
        tasks.add(task);
        storage.saveTasks(tasks);
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
    }

    /**
     * Deletes a task from the list by its index and saves the updated list to the storage file.
     *
     * @param index The index of the task to be deleted (1-based).
     */
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

    /**
     * Marks a task as completed based on its index and saves the updated list to the storage file.
     *
     * @param index The index of the task to be marked as completed (1-based).
     */
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

    /**
     * Unmarks a task, indicating it is not completed yet, based on its index and saves the updated list to the storage file.
     *
     * @param index The index of the task to be unmarked (1-based).
     */
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

    /**
     * Lists all the tasks currently in the list.
     * If no tasks exist, a message is shown indicating that the list is empty.
     */
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

    public void findTask(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).containsWord(taskName)) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }
}
