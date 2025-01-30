package charlie;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

class Storage {
    private final File file;

    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    private void ensureFileExists() {
        try {
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error initializing storage file.");
            exit(1);
        }
    }


    public ArrayList<Task> loadTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        ensureFileExists();
        if (file.exists()) {
            try (Scanner reader = new Scanner(file)) {
                while (reader.hasNextLine()) {
                    tasks.add(Task.addFromFile(reader.nextLine()));
                }
            } catch (IOException e) {
                System.out.println("Error reading from file");
            }
        }
        return tasks;
    }

    public void saveTasks(ArrayList<Task> tasks) {
        try (FileWriter fw = new FileWriter(file)) {
            for (Task task : tasks) {
                fw.write(task.writeToFile());
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
}