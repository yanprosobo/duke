import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Duke {
    private static List<Task> task1 = new ArrayList<>();

    private static void printList (List<Task> task1) {
        printIndentedHorizontalLine();
        int i = 0;
        for (Task temp: task1) {
            printIndentMessage(i+1 + ". " + temp);
            i++;
        }
        printIndentedHorizontalLine();
    }

    private static void printMessageAfterAddingTask(Task task) {
        printIndentedHorizontalLine();
        printIndentMessage("Got it. I've added this task: ");
        printIndentMessage(task.toString());
        printIndentMessage("Now you have " + task1.size() + " task in the list.");
    }
    private static void printIndentMessage (String message) {
        System.out.println("\t" + message);
    }
    private static void printIndentedHorizontalLine() {
        printIndentMessage("____________________________________________________________");
    }
    private static void printWelcome() {
        printIndentedHorizontalLine();
        printIndentMessage("Hello! I'm Duke");
        printIndentMessage("What can I do for you?");
        printIndentedHorizontalLine();
    }
    public static void printGoodbye() {
        printIndentedHorizontalLine();
        printIndentMessage(" Bye. Hope to see you again soon!");
        printIndentedHorizontalLine();
    }
    private static void printReply(String reply) {
        printIndentedHorizontalLine();
        printIndentMessage("added: " + reply);
        printIndentedHorizontalLine();
    }
    private static void reply() {
        String terminateCommand = "bye";
        String listCommand = "list";

        Scanner input = new Scanner(System.in);
        String commands =  input.nextLine();

        if(commands.equals(terminateCommand)) {
            printGoodbye();
            java.lang.System.exit(0);
            return;
        }
        else if (commands.equals(listCommand)){
            printList(task1);
        }
        else {
            List<String> inputList = Arrays.asList(commands.split(" "));
            //String[] values = commands.split(" ");
            if(inputList.get(0).equals("done")) {
                printIndentedHorizontalLine();
                int taskIndex = Integer.parseInt(inputList.get(1));
                task1.get(taskIndex - 1).markAsDone();
                printIndentMessage("Nice! I've marked this task as done:");
                printIndentMessage(task1.get(taskIndex - 1).toString());
                printIndentedHorizontalLine();
            }
            else if (inputList.get(0).equals("todo")){
                Task temptask = new Todo(inputList.subList(1, inputList.size()));
                task1.add(temptask);
                printMessageAfterAddingTask(temptask);
            }
            else if (inputList.get(0).equals("deadline")) {
                Task temptask = new Deadline(inputList.subList(1, inputList.size()));
                task1.add(temptask);
                printMessageAfterAddingTask(temptask);
            }
            else if (inputList.get(0).equals("event")) {
                Task temptask = new Event(inputList.subList(1, inputList.size()));
                task1.add(temptask);
                printMessageAfterAddingTask(temptask);
            }
        }
    }
    public static void main(String[] args) {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        printWelcome();
        while (true) {
            reply();
        }
    }

}
