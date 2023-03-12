package managers;

import exceptions.ManagerSaveException;
import tasksTypes.Epic;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.io.IOException;
import java.util.List;

public interface TaskManager {

    List<Task> getHistory() throws ManagerSaveException;

    void addNewTask(Task obj) throws IOException;

    void addNewEpic(Epic epic) throws IOException;

    void addNewSubtask(Epic epicParent, Subtask subtask) throws ManagerSaveException;

    List<Task> getSimpleTasks() throws ManagerSaveException;

    List<Epic> getEpicTasks();

    List<Subtask> getSubtasks() throws ManagerSaveException;

    void cleanTasks() throws ManagerSaveException;

    Task getTaskById(int id) throws ManagerSaveException;

    void updateTask(Task task, Task newTask) throws ManagerSaveException;

    void deleteTaskById(int id) throws ManagerSaveException;

    void cleanAllEpics() throws ManagerSaveException;

    void deleteEpicById(int id) throws ManagerSaveException;

    Epic getEpicById(int id) throws ManagerSaveException;

    void updateStatusEpic(Epic epic) throws ManagerSaveException;

    List<Subtask> getEpicSubtasks(Epic epic) throws ManagerSaveException;

    void cleanAllSubtasks() throws ManagerSaveException;

    void deleteSubtaskById(int id) throws ManagerSaveException;

    Subtask getSubtaskById(int id) throws ManagerSaveException;

    void updateSubtask(Subtask oldSubtask, Subtask newSubtask) throws ManagerSaveException;

}
