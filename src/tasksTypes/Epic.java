package tasksTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Epic extends Task {

    public Epic() {
        super();
    }

    public Epic(String name) {
        super(name);
    }

    public Epic(String name, String description) {
        super(name, description);
    }

    public Epic (int id, String name, String description, Status status){
        super(id, name, description, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Epic otherEpic = (Epic) obj;
        return Objects.equals(name, otherEpic.name) && Objects.equals(description, otherEpic.description)
                && (id == otherEpic.id) && Objects.equals(status, otherEpic.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDescription(), getId(), getStatus());
    }

    @Override
    public String toString() {
        return "Epic{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status=" + status +
                '}';
    }
}
