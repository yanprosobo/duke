import java.util.Scanner;

public class Duke {
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
        printIndentMessage(reply);
        printIndentedHorizontalLine();
    }
    private static void reply() {
        String terminate = "bye";

        Scanner input = new Scanner(System.in);
        String commands =  input.nextLine();

        if(commands.equals(terminate)) {
            printGoodbye();
            java.lang.System.exit(0);
            return;
        }
        else {
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
