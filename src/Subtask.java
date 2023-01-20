import java.util.Objects;

public class Subtask extends Task {

    protected int epicId;

    public Subtask(int parentId) {
        epicId = parentId;
        this.status = statusTask[0];
    }

    public Subtask(String name, String description, int parentId){
        super(name, description);
        epicId = parentId;
        this.status = statusTask[0];
    }

    @Override
    public void setStatus(String status) {
        super.setStatus(status);
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public void setDescription(String description) {
        super.setDescription(description);
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
        if (!(o instanceof Subtask)) return false;
        if (!super.equals(o)) return false;
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
