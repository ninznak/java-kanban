public class Task {
    protected String name;
    protected String[] description;
    protected static int id;                 // по нему поиск
    protected String status;            // NEW, IN_PROGRESS, DONE

    public Task() {
        this.status = "NEW";
        id++;
    }

    public Task(String name) {
        this.name = name;
        this.status = "NEW";
        id++;
    }

    public Task(String name, String[] description) {
        this.name = name;
        this.description = description;
        this.status = "NEW";
        id++;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public String[] getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
