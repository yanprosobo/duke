public class Task {
    protected String name;
    protected boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }
    public String getName() {
        return this.name;
    }
    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return (isDone ? "Y" : "N");
        //return (isDone ? "\u2713" : "\u2718"); //return tick or X symbols
    }

    public String getPrintable() {
        return  "[" + this.getStatusIcon() + "]" + this.name;
    }
    //...
}
