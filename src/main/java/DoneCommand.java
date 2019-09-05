import java.util.List;

public class DoneCommand extends Command {
    private List<String> inputlist;

    public DoneCommand(List<String> inputlist) {
        this.inputlist = inputlist;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            int taskIndex = Integer.parseInt(inputlist.get(0));
            Task donetask = taskList.get(taskIndex - 1);
            donetask.markAsDone();
            ui.showDoneTask(donetask);
            storage.save((TaskList) taskList);
        } catch (NumberFormatException e) {
            throw new DukeException("Please supply a number. Eg: done 2");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please supply a valid number. Enter 'List' to show current lists of tasks.");
        }
    }
}