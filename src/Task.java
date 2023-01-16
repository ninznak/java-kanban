public class Task {
    protected String name;
    protected String description;
    protected static int id;                 // по нему поиск
    protected String status;            // NEW, IN_PROGRESS, DONE

    public Task() {
        id++;
    }

    public Task(String name) {
        this.name = name;
        id++;
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        id++;
    }

    public Task(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
        id++;
    }


    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
