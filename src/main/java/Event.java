import java.util.List;

public class Event extends Task {
    private String description;
    private DateTime event_start, event_end;

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
        try {
            this.description = String.join(" ", list1.subList(0, start));
            this.event_start = new DateTime(list1.subList(start + 1, start + 3));
            this.event_end = new DateTime(list1.subList(start + 4, start + 6));
        }
        catch (IndexOutOfBoundsException e) {
            throw new DukeException("Please enter valid format: event <event name> /at <event start time> - <event end time>\n \tEach event time should be in the format: dd/mm/yyyy hhmm");
        }
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + this.description + " (at: " + this.event_start + " - " + this.event_end + ")";
    }
}