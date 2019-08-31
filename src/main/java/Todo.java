import java.util.List;

public class Todo extends Task {
    private String description;

    public Todo(List<String> list1) {
        this.description = String.join(" ", list1);
    }
    @Override
    public String toString() {
        return "[T]" + super.toString() + this.description;
    }

}