package managers;

import tasksTypes.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    private static int idGenerator;
    private HashMap<Integer, Task> simpleTasks = new HashMap<>();
    private HashMap<Integer, Epic> epicTasks = new HashMap<>();
    private HashMap<Integer, Subtask> subtasks = new HashMap<>();


    public void addNewTask(Task obj) {           // added different types of tasks
        System.out.println("Добавлена обычная задача TASK, присвоен номер id №" + idGenerator);
        obj.setId(idGenerator++);
        simpleTasks.put(obj.getId(), obj);
    }

    public void addNewEpic(Epic epic) {
        System.out.println("Добавлена задача EPIC, присвоен номер id №" + idGenerator);
        epic.setId(idGenerator);
        epicTasks.put(idGenerator++, epic);
    }

    public void addNewSubtask(Epic epicParent, Subtask subtask) {
        System.out.println("Добавлена подзадача SUBTASK, присвоен номер id №" +
                idGenerator + ". EPIC родитель id №" + epicParent.getId());
        subtask.setId(idGenerator++);
        subtask.setEpicParentId(epicParent.getId());
        subtasks.put(subtask.getId(), subtask);
        epicParent.setStatus(StatusList.statusTask[1]);
    }

    public HashMap<Integer, Task> getSimpleTasks() {
        return simpleTasks;
    }

    public HashMap<Integer, Epic> getEpicTasks() {
        return epicTasks;
    }

    public HashMap<Integer, Subtask> getSubtasks() {
        return subtasks;
    }

    public void cleanTasks() {               // Tasks methods
        simpleTasks.clear();
    }

    public Task getTaskById(int id) {
        return simpleTasks.get(id);
    }

    public void updateTask(Task task, Task newTask) {
        newTask.setId(task.getId());
        simpleTasks.put(task.getId(), newTask);
    }

    public void deleteTaskById(int id) {
        simpleTasks.remove(id);
        System.out.println("Задача tasksTypes.Task " + " id#" + id + " удалена");
    }

    public void cleanAllEpics() {     // tasksTypes.Epic methods
        System.out.println("Все задачи tasksTypes.Epic и их подзадачи удалены");
        epicTasks.clear();
        subtasks.clear();
    }

    public void deleteEpicById(int id) {
        System.out.println("Задача EPIC id-" + id + " удалена");

        epicTasks.remove(id);
        /*for(Integer subtaskId : subtasks.keySet()){
            if (subtasks.get(subtaskId).getEpicParentId() == id){
                subtasks.remove(subtaskId);
            }
        }*/
        for(Map.Entry<Integer, Subtask> subtask : subtasks.entrySet()) {
            if (subtask.getValue().getEpicParentId() == id) {
                subtasks.remove(subtask);
            }
        }

    }

    public Epic getEpicById(int id) {
        System.out.println("Получена EPIC задача id №" + id);
        getEpicSubtasks(epicTasks.get(id));
        return epicTasks.get(id);
    }

    public List<Subtask> getEpicSubtasks(Epic epic) {
        System.out.println("Получены подзадачи от EPIC id №" + epic.getId() + ". Название - " + epic.getName());
        List<Subtask> subtaskList = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            if (subtask.getEpicParentId() == epic.getId()) {
                subtaskList.add(subtask);
            }
        }
        epic.setSubtasks(subtaskList);
        return epic.getSubtasks();
    }

    public void cleanAllSubtasks() {                 //tasksTypes.Subtask methods
        subtasks.clear();
        System.out.println("Все подзадачи очищены!");
        for (Epic epic : epicTasks.values()) {
            epic.setStatus(StatusList.statusTask[0]);
        }
    }

    public void deleteSubtaskById(int id) {
        System.out.println("Подзадача " + " id №" + id + " удалена");
        subtasks.remove(id);
    }

    public Subtask getSubtaskById(int id) {
        System.out.println("Получена подзадача id №" + id);
        return subtasks.get(id);
    }

    public void updateSubtask(Subtask oldSubtask, Subtask newSubtask) {
        int counter = 0;

        System.out.println("Подзадача " + oldSubtask.getId()+ " обновлена");
        newSubtask.setId(oldSubtask.getId());
        newSubtask.setEpicParentId(oldSubtask.getEpicParentId());
        subtasks.put(oldSubtask.getId(), newSubtask);

        if (!newSubtask.getStatus().equals("DONE")){
            return;
        }

        List<Subtask> subtaskForCheck = epicTasks.get(oldSubtask.getEpicParentId()).getSubtasks();
        for (Subtask check : subtaskForCheck) {
            if (check.getStatus().equals("DONE")){
                counter++;
            }
        }
        if (counter == subtaskForCheck.size()){
            epicTasks.get(oldSubtask.getEpicParentId()).setStatus("DONE");
        }
    }
}
