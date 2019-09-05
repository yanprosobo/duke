import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Parser {
    public static Command parse (String wholecommand) throws DukeException {
        List<String> inputList = Arrays.asList(wholecommand.split(" "));
        String action = inputList.get(0);
        List<String> details = inputList.subList(1, inputList.size());

        switch (action) {
            case "list":
                return new ListCommand();
            case "todo":
            case "event":
            case "deadline":
                return new AddCommand(inputList);
            case "find":
                return new FindCommand(details);
            case "done":
                return new DoneCommand(details);
            case "delete":
                return new DeleteCommand(details);
            case "bye":
                return new ByeCommand();
            default:
                throw new DukeException("Please enter a valid command: list/todo/event/deadline/find/done/delete/bye");
        }
    }
}
