import java.io.Serializable;

public abstract class Task implements Serializable {
    protected String name;
    protected boolean isDone;

    public String getName() {
        return this.name;
    }

    public Task() {
        this.isDone = false;
    }
    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
        //return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    @Override
    public String toString() {
        return  "[" + this.getStatusIcon() + "]";
    }
}
