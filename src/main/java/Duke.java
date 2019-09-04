import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Duke {
    private static List<Task> task1 = new ArrayList<>();
    private static Storage storage = new Storage("tasks.txt");

    private static void printList (List<Task> task1) {
        printIndentedHorizontalLine();
        int i = 0;
        if (task1.size() == 0) {
            printIndentMessage("You have no task in your list");
        }
        else {
            System.out.print("\tHere are the");
            if (task1.size() == 1) {
                System.out.print (" task");
            }
            else {
                System.out.print(" tasks");
            }
            System.out.print(" in your list:\n");
        }
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
        System.out.print("\tNow you have " + task1.size());
        if (task1.size() == 1) {
            System.out.print(" task");
        }
        else {
            System.out.print(" tasks");
        }
        System.out.print(" in the list.\n");
        //printIndentMessage("Now you have " + task1.size() + " task in the list.");
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
    private static void reply() throws DukeException{
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
                try {
                    int taskIndex = Integer.parseInt(inputList.get(1));
                    task1.get(taskIndex - 1).markAsDone();
                    printIndentedHorizontalLine();
                    printIndentMessage(task1.get(taskIndex - 1).toString());
                    printIndentedHorizontalLine();
                }
                catch (NumberFormatException e) {
                    throw new DukeException("Please provide a valid format. E.g. done 4");
                }
                catch (IndexOutOfBoundsException e) {
                    throw new DukeException("Please provide the task number. E.g. done 4");
                }
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
            else {
                throw new DukeException("Please give a proper command: LIST BYE DONE TODO EVENT DEADLINE");
            }
            storage.save(task1);
        }
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printWelcome();

        task1 = storage.load();

        while (true) {
            try {
                reply();
            }
            catch (DukeException e) {
                printIndentMessage(e.getMessage());
            }
        }
    }
}
