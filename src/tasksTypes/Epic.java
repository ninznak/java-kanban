package tasksTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Epic extends Task {

    protected List<Subtask> subtasks;

    public Epic() {
        super();
        this.subtasks = new ArrayList<>();
    }

    public Epic(String name) {
        super(name);
        this.subtasks = new ArrayList<>();
    }

    public Epic(String name, String description) {
        super(name, description);
        this.subtasks = new ArrayList<>();
    }

    public List<Subtask> getSubtasks() {
        System.out.println("Все подзадачи эпика " + this.name);
        return subtasks;
    }

    public void setSubtasks(List<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public void cleanSubtasksArray() {
        subtasks.clear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Epic) || !super.equals(o)) return false;
        Epic epic = (Epic) o;
        return getSubtasks().equals(epic.getSubtasks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSubtasks());
    }

    @Override
    public String toString() {
        return "tasksTypes.Epic{" +
                "subtasks=" + subtasks +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
