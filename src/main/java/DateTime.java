//to do error handling of dates.
import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

public class DateTime implements Serializable {
    private Calendar at;

    public DateTime(List<String> tokens) throws DukeException {
        Calendar calendar = Calendar.getInstance();
        try {
            String[] date = tokens.get(0).split("/");

            calendar.set(Calendar.DATE, Integer.parseInt(date[0])); //day of the month
            calendar.set(Calendar.MONTH, Integer.parseInt(date[1]) - 1); // jan is 0, dec is 11
            calendar.set(Calendar.YEAR, Integer.parseInt(date[2]));

            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(tokens.get(1))/100); // set with the first 2 elements - the hour
            calendar.set(Calendar.MINUTE, Integer.parseInt(tokens.get(1)) % 100); // set with the last 2 elements, the minutes
            calendar.set(Calendar.SECOND, 0);

            this.at = calendar;
        }
        catch (Exception e) {
            throw new DukeException("Invalid datetime. Correct format: dd/mm/yyyy hhmm");
        }
    }

    @Override
    public String toString() {
        return (""+ at.getTime());
    }
}