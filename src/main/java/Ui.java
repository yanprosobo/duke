import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    private void printIndentedMessage(String message) {
        System.out.println("\t" + message);
    }

    public void printIndentedHorizontalLine() {
        printIndentedMessage("____________________________________________________________");
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        printIndentedHorizontalLine();
        printIndentedMessage("Hello! I'm Duke");
        printIndentedMessage("What can I do for you?");
        printIndentedHorizontalLine();
    }

    public void printGoodBye() {
        printIndentedMessage("Bye. Hope to see you again soon!");
    }

    public void showError(String message) {
        printIndentedMessage(message);
    }

    public void showTaskAdded(List<Task> task1, Task task) {
        printIndentedMessage("Got it . I've added this task: ");
        printIndentedMessage(task.toString());
        printIndentedMessage("Now you have " + task1.size() + ((task1.size() == 1) ?  " tasks" : " task") + " in the list");
        //printIndentMessage("Now you have " + task1.size() + " task in the list.");
    }

    public void showTaskList(List<Task> task1) {
        if (task1.size() == 0) {
            printIndentedMessage("You have no task in your list.");
        }
        else {
            printIndentedMessage("Here are the tasks in your list:");
        }
        printList(task1);
    }

    public void showSearchResult(List<Task> task1) {
        printIndentedMessage("Here are the matching tasks in your list:");
        printList(task1);
    }

    public void showDeletedTask(List<Task> task1, Task task) {
        printIndentedMessage("Noted. I've removed this task:");
        printIndentedMessage(task.toString());
        printIndentedMessage("Now you have " + task1.size() + ((task1.size() == 1) ?  " tasks" : " task") + " in the list");
    }

    public void showDoneTask(Task task) {
        printIndentedMessage("Nice! I've marked this task as done:");
        printIndentedMessage(task.toString());
    }

    public String readCommand() {
        return sc.nextLine();
    }

    private void showNumTasks(List<Task> task1) {
        printIndentedMessage("Now you have "
                + task1.size()
                + (task1.size() > 1 ? " tasks" : " task")
                + " in the list.");
    }

    private void printList(List<Task> task1) {
        //printIndentedHorizontalLine();
        int i = 0;
        for (Task temp : task1) {
            printIndentedMessage(i+1 + ". " + temp);
            i++;
        }
        //printIndentedHorizontalLine();
    }
}