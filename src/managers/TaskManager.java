package managers;

import tasksTypes.Epic;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.util.List;

public interface TaskManager {

    void addNewTask(Task obj);

    void addNewEpic(Epic epic);

    void addNewSubtask(Epic epicParent, Subtask subtask);

    List<Task> getSimpleTasks();

    List<Epic> getEpicTasks();

    List<Subtask> getSubtasks();

    void cleanTasks();

    Task getTaskById(int id);

    void updateTask(Task task, Task newTask);

    void deleteTaskById(int id);

    void cleanAllEpics();

    void deleteEpicById(int id);

    Epic getEpicById(int id);

    List<Subtask> getEpicSubtasks(Epic epic);

    void cleanAllSubtasks();

    void deleteSubtaskById(int id);

    Subtask getSubtaskById(int id);

    void updateSubtask(Subtask oldSubtask, Subtask newSubtask);

    void getHistory();
}
