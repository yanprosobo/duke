import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Storage {
    private String fileName;

    public Storage(String fileName) {
        this.fileName = fileName;
    }

    // Unchecked type coercion is necessary here.
    // And possible cast exceptions are handled
    @SuppressWarnings("unchecked")
    public TaskList load() throws DukeException{
        try {
            FileInputStream fileStream = new FileInputStream(this.fileName);
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            TaskList tasks = (TaskList) objectStream.readObject();
            objectStream.close();
            return tasks;
        } catch (FileNotFoundException e) {
            throw new DukeException("File doesn't exist, not loading anything.");
        } catch (IOException e) {
            throw new DukeException("An unexpected error occurred when reading the file, not loading anything. " + e);
        } catch (ClassNotFoundException e) {
            throw new DukeException("Invalid file contents, not loading anything.");
        } catch (ClassCastException e) {
            throw new DukeException("Invalid file contents, not loading anything.");
        }
    }

    public void save(TaskList tasks) throws DukeException {
        try {
            FileOutputStream fileStream = new FileOutputStream(this.fileName);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(tasks);
            objectStream.close();
        } catch (FileNotFoundException e) {
            throw new DukeException("Unable to open " + this.fileName);
        } catch (IOException e) {
            throw new DukeException("An unexpected error occurred when writing to the file. " + e);
        }
    }
}