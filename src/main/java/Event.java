import java.util.List;

public class Event extends Task {
    private String description;
    private String time;

    public Event(List<String> list1) throws DukeException {
        if (list1.size() <= 2) {
            throw new DukeException("Please enter valid format: event <event name> /at <event time>");
        }
        int start = list1.indexOf("/at");
        if (start == 0) {
            throw new DukeException ("Did you forget about event name? Please enter the valid format: event <event name> /at <event time>");
        }
        else if (start == -1) {
            throw new DukeException("Did you forget about /at? Please enter the valid format: event <event name> /at <event time>");
        }
        this.description = String.join(" ", list1.subList(0, start));
        this.time = String.join(" ", list1.subList(start + 1, list1.size()));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + this.description + " (at: " + this.time + ")";
    }
}