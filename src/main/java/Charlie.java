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
            String[] words = input.split("\\s+");
            if (input.equals("list")) {
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(i + 1 + ". " + tasks.get(i).toString());
                }
            }

            else if (input.equals("bye")) {
                break;
            }
            else {
                if (words.length == 2) {
                    if (words[0].equals("mark")) {
                        int index = Integer.parseInt(words[1]) - 1;
                        tasks.get(index).mark();
                        System.out.println("Nice, I have marked your task:");
                        System.out.println(tasks.get(index).toString());
                    } else if (words[0].equals("unmark")) {
                        int index = Integer.parseInt(words[1]) - 1;
                        tasks.get(index).unmark();
                        System.out.println("I have unmarked your task:");
                        System.out.println(tasks.get(index).toString());
                    } else {
                        tasks.add(new Task(input));
                        System.out.println("added: " + input);
                    }
                } else {
                    tasks.add(new Task(input));
                    System.out.println("added: " + input);
                }
            }
        }
        System.out.println("Goodbye! Hope to see you soon!");
    }
}
