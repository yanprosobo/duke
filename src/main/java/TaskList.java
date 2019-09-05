import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TaskList implements Serializable{
    private List<Task> task1;

    public TaskList() {
        this.task1 = new ArrayList<>();
    }

    public TaskList (List<Task> task1) {
        this.task1 = task1;
    }

    public void add (Task task) {
        task1.add(task);
    }

    public Task get(int i) {
        return task1.get(i);
    }

    public void remove (int i) {
        task1.remove(i);
    }

    public int size () {
        return task1.size();
    }

    public List<Task> getTaskList () {
        return task1;
    }

}
