import java.util.List;

public class DoneCommand extends Command {
    private List<String> words;

    public DoneCommand(List<String> words) {
        this.words = words;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        try {
            int taskIndex = Integer.parseInt(words.get(0));
            Task donetask = taskList.get(taskIndex - 1);
            donetask.markAsDone();
            ui.showDoneTask(donetask);
            storage.save((TaskList) taskList);
        } catch (NumberFormatException e) {
            throw new DukeException("Please supply a number. Eg: done 2");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please supply a valid number.");
        }
    }
}