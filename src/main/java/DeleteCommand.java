import java.util.List;

public class DeleteCommand extends Command {
    private List<String> inputlist;

    public DeleteCommand(List<String> inputlist) {
        this.inputlist = inputlist;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            int taskIndex = Integer.parseInt(inputlist.get(0)) ;
            Task toRemove = taskList.get(taskIndex - 1);
            taskList.remove(taskIndex - 1 );
            ui.showDeletedTask(taskList.getTaskList(), toRemove);
            storage.save((TaskList) taskList);
        } catch (NumberFormatException e) {
            throw new DukeException("Please supply a number. Eg: done 2");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please supply a valid number.");
        }

    }
}