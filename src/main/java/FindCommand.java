import java.util.List;
import java.util.stream.Collectors;

public class FindCommand extends Command {
    private List<String> inputlist;

    public FindCommand(List<String> inputlist) {
        this.inputlist = inputlist;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        if (inputlist.size() > 0) {
            String searchTerm = String.join(" ", inputlist.subList(0, inputlist.size()));
            List<Task> filteredTasks =
                    taskList.getTaskList().stream()
                            .filter(task -> task.containsKeyword(searchTerm))
                            .collect(Collectors.toList());
            if (filteredTasks.size() > 0) {
                ui.showSearchResult(filteredTasks);
            } else {
                throw new DukeException("There are no matching tasks.");
            }
        } else {
            throw new DukeException("Please enter at least a keyword to search.");
        }
    }
}