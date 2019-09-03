public class DukeException extends Exception{
    public DukeException(String message) {
        super("____________________________________________________________\n" +
                "\t" + message + "\n" +
                "\t____________________________________________________________\n");
    }
}
