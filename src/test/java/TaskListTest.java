import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskListTest {
    @Test
    void add_works() throws DukeException {
        TaskList taskList = new TaskList();
        String dummy = "read book";
        List<String> wordList = Arrays.asList(dummy.split(" "));
        Task task = new Todo(wordList);
        taskList.add(task);
        assertEquals(task, taskList.get(0));
    }
}