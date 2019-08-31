import java.util.List;

public class Event extends Task {
    private String description;
    private String time;

    public Event(List<String> list1) {
        int start = list1.indexOf("/at");
        this.description = String.join(" ", list1.subList(0, start));
        this.time = String.join(" ", list1.subList(start + 1, list1.size()));
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + this.description + " (at: " + this.time + ")";
    }
}