package tasksTypes;

import java.util.Objects;

public class Subtask extends Task {

    protected int epicId;

    public Subtask(int parentId) {
        epicId = parentId;
        this.status = Status.NEW;
    }

    public Subtask(String name, String description) {
        super(name, description);
        this.status = Status.NEW;
    }

    public Subtask(String name, String description, Status status) {
        super(name, description, status);
    }

    public void setEpicParentId(int epicParentId) {
        this.epicId = epicParentId;
    }

    public int getEpicParentId() {
        return epicId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Subtask) || !super.equals(o)) return false;
        Subtask subtask = (Subtask) o;
        return epicId == subtask.epicId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), epicId);
    }

    @Override
    public String toString() {
        return "Subtask{" +
                "epicId=" + epicId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
