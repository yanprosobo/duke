import java.util.List;
import java.util.Scanner;

public class Ui {
    private Scanner sc;

    public Ui() {
        sc = new Scanner(System.in);
    }

    public void beginBlock() {
        printHR();
    }

    public void endBlock() {
        printHR();
    }

    public void showWelcome() {
        beginBlock();
        printIndented("Hello! I'm Duke");
        printIndented("What can I do for you?");
        endBlock();
    }

    public void showBye() {
        printIndented("Bye. Hope to see you again soon!");
    }

    public void showError(String message) {
        printIndented(message);
    }

    public void showTaskAdded(List<Task> tasks, Task task) {
        printIndented("Got it . I've added this task:");
        printIndented("  " + task);
        showNumTasks(tasks);
    }

    public void showTaskList(List<Task> tasks) {
        if (tasks.size() == 0) {
            printIndented("You have no task in your list.");
        }
        else {
            printIndented("Here are the tasks in your list:");
        }
        showTasks(tasks);
    }

    public void showSearchResult(List<Task> tasks) {
        printIndented("Here are the matching tasks in your list:");
        showTasks(tasks);
    }

    public void showDeletedTask(List<Task> tasks, Task task) {
        printIndented("Noted. I've removed this task:");
        printIndented("  " + task);
        showNumTasks(tasks);
    }

    public void showDoneTask(Task task) {
        printIndented("Nice! I've marked this task as done:");
        printIndented("  " + task);
    }

    public String readCommand() {
        return sc.nextLine();
    }

    private void printIndented(String line) {
        System.out.println("    " + line);
    }

    private void showNumTasks(List<Task> tasks) {
        printIndented("Now you have "
                + tasks.size()
                + (tasks.size() > 1 ? " tasks" : " task")
                + " in the list.");
    }

    private void showTasks(List<Task> tasks) {
        int counter = 1;
        for (Task task : tasks) {
            printIndented(counter++ + ". " + task);
        }
    }

    private void printHR() {
        printIndented("____________________________________________________________");
    }
}