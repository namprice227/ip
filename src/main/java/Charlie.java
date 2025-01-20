import java.util.ArrayList;
import java.util.Scanner;

public class Charlie {

    public static void main(String[] args) {
        ArrayList<Task> tasks = new ArrayList<Task>();
        System.out.println("Hello! I'm Charlie");
        System.out.println("What can I do for you?");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i).toString());
                }
            }
            else if (input.equals("bye")) {
                break;
            } else {
                tasks.add(new Task(input));
                System.out.println("added: " + input);
            }

        }
        System.out.println("Goodbye! Hope to see you soon!");
    }
}
