import java.util.List;

public class Deadline extends Task {
    private String description;
    private String deadline;

    public Deadline(List<String> list1) {
        int start = list1.indexOf("/by");
        this.description = String.join(" ", list1.subList(0, start));
        this.deadline = String.join(" ", list1.subList(start+ 1, list1.size()));
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + this.description + " (by: " + this.deadline + ")";
    }
}