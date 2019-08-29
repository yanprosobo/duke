import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    private static List<Task> task1 = new ArrayList<>();

    private static void printList (List<Task> task1) {
        printIndentedHorizontalLine();
        int i = 0;
        for (Task temp: task1) {
            printIndentMessage(i+1 + ". " + temp.getPrintable());
            i++;
        }
        printIndentedHorizontalLine();
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
            String[] values = commands.split(" ");
            if(values[0].equals("done")) {
                printIndentedHorizontalLine();
                int taskIndex = Integer.parseInt(values[1]);
                task1.get(taskIndex - 1).markAsDone();
                printIndentMessage("Nice! I've marked this task as done:");
                printIndentMessage(task1.get(taskIndex - 1).getPrintable());
                printIndentedHorizontalLine();
            }
            else {
                Task temptask = new Task(commands);
                task1.add(temptask);
                printReply(commands);
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
