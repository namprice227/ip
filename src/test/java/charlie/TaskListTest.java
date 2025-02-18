package charlie;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TaskListTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private Storage storage;
    private TaskList taskList;


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        this.storage = new Storage("data/test.txt");
        this.taskList = new TaskList(storage);
    }

    @Test
    void testListTasksEmpty() {
        taskList.listTasks(); // Call the method
        String expectedOutput = "There are no tasks, please feel free to add more\r\n";
        assertEquals(expectedOutput, outputStreamCaptor.toString());

    }

    @Test
    void testAddTask() {
        Task task1 = new Deadline("do homework /by 2022-07-03");
        Task task2 = new Event("career fair /from 2022-07-03 /to 2022-08-03");
        taskList.addTask(task1);
        taskList.addTask(task2);
        String expectedOutput = String.join(System.lineSeparator(),
                "Got it. I've added this task:",
                "[D][ ] do homework (by: Jul 3 2022)",
                "Now you have 1 tasks in the list.",
                "Got it. I've added this task:",
                "[E][ ] career fair (from: Jul 3 2022 to: Aug 3 2022)",
                "Now you have 2 tasks in the list.",
                "" // Ensure the final newline is included
        );

        assertEquals(expectedOutput, outputStreamCaptor.toString());

    }

    @Test
    void testDeleteTask() {
        taskList.deleteTask(1);
        String expectedOutput = String.join(System.lineSeparator(),
                "Noted. I've removed this task:",
                "  [D][ ] do homework (by: Jul 3 2022)",
                "Now you have 1 tasks in the list.",
                ""
        );
        assertEquals(expectedOutput, outputStreamCaptor.toString());

    }
}
