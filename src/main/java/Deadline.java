import java.util.List;

public class Deadline extends Task {
    private String description;
    private DateTime deadline;

    public Deadline(List<String> list1) throws DukeException {
        if (list1.size() <= 2) {
            throw new DukeException("Please enter valid format: deadline <deadline name> /at <deadline time>");
        }
        int start = list1.indexOf("/by");
        if (start == 0) {
            throw new DukeException ("Did you forget about deadline name? Please enter the valid format: deadline <deadline name> /at <deadline time>");
        }
        else if (start == -1) {
            throw new DukeException("Did you forget about /by? Please enter the valid format: deadline <deadline name> /at <deadline time>");
        }
        this.description = String.join(" ", list1.subList(0, start));
        this.deadline = new DateTime(list1.subList(start+ 1, list1.size()));
    }

    @Override
    public boolean containsKeyword(String keyword) {
        return this.description.contains(keyword);
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + this.description + " (by: " + this.deadline + ")";
    }
}