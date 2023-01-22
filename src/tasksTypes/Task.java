package tasksTypes;

import java.util.Objects;

import managers.StatusList;
import managers.WhitespaceDeleter;

public class Task implements StatusList {
    protected String name;
    protected String description;
    protected int id;                 // по нему поиск
    protected String status;            // NEW, IN_PROGRESS, DONE

    public Task() {
        this.status = StatusList.statusTask[0];
    }

    public Task(String name) {
        this.name = name;
        this.status = StatusList.statusTask[0];
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.status = StatusList.statusTask[0];
    }

    public Task(String name, String description, String status) {
        this.name = name;
        this.description = description;
        this.status = status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String[] getDescription() {
        return WhitespaceDeleter.clean(description.split(","));
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Task otherTask = (Task) obj;
        return Objects.equals(name, otherTask.name) && Objects.equals(description, otherTask.description)
                && (id == otherTask.id) && Objects.equals(status, otherTask.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getId(), getStatus());
    }

    @Override
    public String toString() {
        return "tasksTypes.Task{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
