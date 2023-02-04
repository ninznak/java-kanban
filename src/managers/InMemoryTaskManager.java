package managers;

import tasksTypes.*;

import java.util.*;


public class InMemoryTaskManager implements TaskManager {
    private static int idGenerator;
    private Map<Integer, Task> simpleTasks = new HashMap<>();
    private Map<Integer, Epic> epicTasks = new HashMap<>();
    private Map<Integer, Subtask> subtasks = new HashMap<>();
    private HistoryManager historyManager = Managers.getDefaultHistory();

    @Override
    public List<Task> getHistory() {
        System.out.println("История просмотра задач");
        return historyManager.getHistory();
    }

    @Override
    public void addNewTask(Task obj) {           // added different types of tasks
        System.out.println("Добавлена обычная задача TASK, присвоен номер id №" + idGenerator);
        obj.setId(idGenerator++);
        simpleTasks.put(obj.getId(), obj);
    }

    @Override
    public void addNewEpic(Epic epic) {
        System.out.println("Добавлена задача EPIC, присвоен номер id №" + idGenerator);
        epic.setId(idGenerator);
        updateStatusEpic(epic);
        epicTasks.put(idGenerator++, epic);
    }

    @Override
    public void addNewSubtask(Epic epicParent, Subtask subtask) {  //!!
        System.out.println("Добавлена подзадача SUBTASK, присвоен номер id №" +
                idGenerator + ". EPIC родитель id №" + epicParent.getId());
        subtask.setId(idGenerator++);
        subtask.setEpicParentId(epicParent.getId());
        subtasks.put(subtask.getId(), subtask);
        updateStatusEpic(epicParent);
    }

    @Override
    public List<Task> getSimpleTasks() {
        return new ArrayList<>(simpleTasks.values());
    }

    @Override
    public List<Epic> getEpicTasks() {
        return new ArrayList<>(epicTasks.values());
    }

    @Override
    public List<Subtask> getSubtasks() {
        return new ArrayList<>(subtasks.values());
    }

    @Override
    public void cleanTasks() {               // Tasks methods
        simpleTasks.clear();
    }

    @Override
    public Task getTaskById(int id) {
        historyManager.addTask(simpleTasks.get(id));
        return simpleTasks.get(id);
    }

    @Override
    public void updateTask(Task task, Task newTask) {
        newTask.setId(task.getId());
        simpleTasks.put(task.getId(), newTask);
    }

    @Override
    public void deleteTaskById(int id) {
        simpleTasks.remove(id);
        System.out.println("Задача tasksTypes.Task " + " id#" + id + " удалена");
    }

    @Override
    public void cleanAllEpics() {     // tasksTypes.Epic methods
        System.out.println("Все задачи tasksTypes.Epic и их подзадачи удалены");
        epicTasks.clear();
        subtasks.clear();
    }

    @Override
    public void deleteEpicById(int id) {
        System.out.println("Задача EPIC id-" + id + " удалена вместе с подзадачами");
        epicTasks.remove(id);
        Iterator<Integer> it = subtasks.keySet().iterator();

        while (it.hasNext()) {
            Integer key = it.next();
            if (subtasks.get(key).getEpicParentId() == id) {
                it.remove();
            }
        }
    }

    @Override
    public Epic getEpicById(int id) {
        historyManager.addTask(epicTasks.get(id));
        System.out.println("Вывод EPIC задачи id №" + id);
        return epicTasks.get(id);
    }

    @Override
    public List<Subtask> getEpicSubtasks(Epic epic) {
        System.out.println("Получены подзадачи от EPIC id №" + epic.getId() + ". Название - " + epic.getName());
        List<Subtask> subtaskList = new ArrayList<>();
        for (Subtask subtask : subtasks.values()) {
            if (subtask.getEpicParentId() == epic.getId()) {
                subtaskList.add(subtask);
            }
        }
        return subtaskList;
    }

    @Override
    public void updateStatusEpic(Epic epic) {
        int counterDone = 0;
        List<Subtask> subtaskForCheck = getEpicSubtasks(epic);

        if (getEpicSubtasks(epic).isEmpty()) {
            epic.setStatus(Status.NEW);
        } else {
            for (Subtask check : subtaskForCheck) {
                if (check.getStatus().equals(Status.DONE)) {
                    counterDone++;
                }
            }
            if (counterDone == subtaskForCheck.size()) {
                epic.setStatus(Status.DONE);
            } else {
                epic.setStatus(Status.IN_PROGRESS);
            }
        }
    }

    @Override
    public void cleanAllSubtasks() {                 //tasksTypes.Subtask methods
        subtasks.clear();
        System.out.println("Все подзадачи очищены!");
        for (Epic epic : epicTasks.values()) {
            updateStatusEpic(epic);
        }
    }

    @Override
    public void deleteSubtaskById(int id) {
        System.out.println("Подзадача " + " id №" + id + " удалена");
        subtasks.remove(id);
        updateStatusEpic(getEpicById(getSubtaskById(id).getEpicParentId()));
    }

    @Override
    public Subtask getSubtaskById(int id) {
        historyManager.addTask(subtasks.get(id));
        System.out.println("Получена подзадача id №" + id);
        return subtasks.get(id);
    }

    @Override
    public void updateSubtask(Subtask oldSubtask, Subtask newSubtask) {

        System.out.println("Подзадача " + oldSubtask.getId() + " обновлена");
        newSubtask.setId(oldSubtask.getId());
        newSubtask.setEpicParentId(oldSubtask.getEpicParentId());
        subtasks.put(oldSubtask.getId(), newSubtask);
        updateStatusEpic(epicTasks.get(oldSubtask.getEpicParentId()));
    }
}
