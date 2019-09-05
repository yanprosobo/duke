public class ListCommand extends Command {
    ListCommand() {

    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        ui.showTaskList(taskList.getTaskList());
    }
}