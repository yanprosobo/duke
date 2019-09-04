import java.util.List;

public class Todo extends Task {
    private String description;

    public Todo(List<String> list1) throws DukeException{
        if (list1.size() == 0) {
            throw new DukeException("Please enter valid format: todo <taskname>");
        }
        this.description = String.join(" ", list1);
    }

    @Override
    public boolean containsKeyword(String keyword) {
        return this.description.contains(keyword);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString() + this.description;
    }

}