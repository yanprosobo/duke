import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Duke {
    private static List<String> list1 = new ArrayList<>();

    private static void printList (List<String> list1) {
        printIndentedHorizontalLine();
        int i = 0;
        for (String temp: list1) {
            printIndentMessage(i+1 + ". " + temp);
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
            printList(list1);
        }
        else {
            list1.add(commands);
            printReply(commands);
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
