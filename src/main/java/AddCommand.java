import java.util.List;

public class AddCommand extends Command {
    private List <String> inputlist;
    public AddCommand (List<String> inputlist) {
        this.inputlist = inputlist;
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        switch(inputlist.get(0)){
            case "todo":
                Todo newTodo = new Todo(inputlist.subList(1, inputlist.size()));
                taskList.add(newTodo);
                ui.showTaskAdded(taskList.getTaskList(), newTodo);
                storage.save((TaskList) taskList);
                break;
            case "deadline":
                Deadline newDeadline = new Deadline(inputlist.subList(1, inputlist.size()));
                taskList.add(newDeadline);
                ui.showTaskAdded(taskList.getTaskList(), newDeadline);
                storage.save((TaskList) taskList);
                break;
            case "event":
                Event newEvent = new Event(inputlist.subList(1, inputlist.size()));
                taskList.add(newEvent);
                ui.showTaskAdded(taskList.getTaskList(), newEvent);
                storage.save((TaskList) taskList);
        }
    }
}
