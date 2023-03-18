package managers;

import exceptions.ManagerSaveException;
import tasksTypes.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager implements TaskManager {

    private final File file;

    public FileBackedTasksManager(File file) {
        this.file = file;
    }

    private <T extends Task> void writeTasks(List<T> tasks, Writer writer) throws IOException { //построчно пишем задачи
        for (Task task : tasks) {
            writer.write((toFileString(task) + "\n"));
        }
    }

    @Override
    public List<Task> getHistory() throws ManagerSaveException {
        List<Task> task = super.getHistory();
        save();
        System.out.println("История просмотра задач: " + historyToString(getHistoryManager()));
        return task;
    }

    @Override
    public void addNewTask(Task obj) throws IOException {
        super.addNewTask(obj);
        save();
    }

    @Override
    public void addNewEpic(Epic epic) throws IOException {
        super.addNewEpic(epic);
        save();
    }

    @Override
    public void addNewSubtask(Epic epicParent, Subtask subtask) throws ManagerSaveException {
        super.addNewSubtask(epicParent, subtask);
        save();
    }

    @Override
    public List<Task> getSimpleTasks() {
        List<Task> tasks = super.getSimpleTasks();
        return tasks;
    }

    @Override
    public List<Epic> getEpicTasks() {
        List<Epic> epicTasks = super.getEpicTasks();
        return epicTasks;
    }

    @Override
    public List<Subtask> getSubtasks() {
        List<Subtask> subtasks = super.getSubtasks();
        return subtasks;
    }

    @Override
    public void cleanTasks() throws ManagerSaveException {
        super.cleanTasks();
        save();
    }

    @Override
    public Task getTaskById(int id) {
        Task task = super.getTaskById(id);
        return task;
    }

    @Override
    public void updateTask(Task task, Task newTask) throws ManagerSaveException {
        super.updateTask(task, newTask);
        save();
    }

    @Override
    public void deleteTaskById(int id) throws ManagerSaveException {
        super.deleteTaskById(id);
        save();
    }

    @Override
    public void cleanAllEpics() throws ManagerSaveException {
        super.cleanAllEpics();
        save();
    }

    @Override
    public void deleteEpicById(int id) throws ManagerSaveException {
        super.deleteEpicById(id);
        save();
    }

    @Override
    public Epic getEpicById(int id) {
        return super.getEpicById(id);
    }

    @Override
    public void updateStatusEpic(Epic epic) throws ManagerSaveException {
        super.updateStatusEpic(epic);
        save();
    }

    @Override
    public List<Subtask> getEpicSubtasks(Epic epic) {
        List<Subtask> subtasks = super.getEpicSubtasks(epic);
        return subtasks;

    }

    @Override
    public void cleanAllSubtasks() throws ManagerSaveException {
        super.cleanAllSubtasks();
        save();
    }

    @Override
    public void deleteSubtaskById(int id) throws ManagerSaveException {
        super.deleteSubtaskById(id);
        save();
    }

    @Override
    public Subtask getSubtaskById(int id) {
        Subtask subtask = super.getSubtaskById(id);
        return subtask;
    }

    @Override
    public void updateSubtask(Subtask oldSubtask, Subtask newSubtask) throws ManagerSaveException {
        super.updateSubtask(oldSubtask, newSubtask);
        save();
    }

    private String toFileString(Task task) {            // парсим объект задачи в строку нужного формата
        String type = TaskType.TASK.name();
        String parentEpicId = "";                       // пятая колонка которая заполнена только у SUBTASK

        if (task instanceof Epic) {
            type = TaskType.EPIC.name();
        } else if (task instanceof Subtask) {
            type = TaskType.SUBTASK.name();
            parentEpicId = "," + ((Subtask) task).getEpicParentId();
        }
        String fileString = task.getId() + "," +
                type + "," +
                task.getName() + "," +
                task.getStatus() + "," +
                String.join(" ", task.getDescription());

        return fileString + parentEpicId;
    }

    private static String historyToString(HistoryManager manager) {     // парсим список истории в строку из одних ID задач
        List<String> taskIds = new ArrayList<>();

        for (Task task : manager.getHistory()) {
            taskIds.add(String.valueOf(task.getId()));
        }
        return String.join(",", taskIds);
    }

    private void save() throws ManagerSaveException {        // метод сохранения изменений, пишем задачи каждого списка
        try (Writer writer = new FileWriter((file), StandardCharsets.UTF_8)) {
            writer.write("id,type,name,status, description, epic\n");
            writeTasks(getSimpleTasks(), writer);
            writeTasks(getEpicTasks(), writer);
            writeTasks(getSubtasks(), writer);
            writer.write("\n");
            writer.write(historyToString(getHistoryManager()));
        } catch (IOException e) {
            throw new ManagerSaveException("Произошла ошибка записи " + e);
        }
    }

    private static List<Integer> historyFromString(String value) {      // получение списка ID из строки истории
        List<Integer> tasksIds = new ArrayList<>();

        if (!value.isBlank()) {
            String[] idsString = value.split(",");
            for (String idString : idsString) {
                tasksIds.add(Integer.valueOf(idString));
            }
        }
        return tasksIds;
    }

    private void readHistory(List<Integer> history) {
        for (Integer currentId : history) {
            if (getSimpleTasks().contains(getTaskById(currentId))) {
                getHistoryManager().addTask((getTaskById(currentId)));
            } else if (getEpicTasks().contains(getEpicById(currentId))) {
                getHistoryManager().addTask((getEpicById(currentId)));
            } else {
                getHistoryManager().addTask(getSubtaskById(currentId));
            }
        }
    }

    public static FileBackedTasksManager loadFromFile(File file) throws IOException {
        FileBackedTasksManager fileManager = new FileBackedTasksManager(file);

        try (BufferedReader brReader = new BufferedReader(new FileReader((file), StandardCharsets.UTF_8))) {
            brReader.readLine();
            while (brReader.ready()) {
                String line = brReader.readLine();
                if (line.isEmpty()) {
                    List<Integer> history = historyFromString(brReader.readLine());
                    fileManager.readHistory(history);
                    break;
                } else {
                    Task thisTask = fromString(line);
                    fileManager.readAllTasks(thisTask);
                }
            }
        } catch (IOException exception) {
            System.out.println("Ошибка чтения файла.");
            exception.printStackTrace();
        }
        return fileManager;
    }


    private <T extends Task> void readAllTasks(Task currentTask) throws IOException {
        if (currentTask instanceof Epic) {
            epicTasks.put(currentTask.getId(), (Epic) currentTask);
        } else if (currentTask instanceof Subtask) {
            int epicId = ((Subtask) currentTask).getEpicParentId();
            Epic epic = getEpicById(epicId);
            epic.setId(((Subtask) currentTask).getEpicParentId());
            subtasks.put(currentTask.getId(), (Subtask) currentTask);
        } else {
            simpleTasks.put(currentTask.getId(), currentTask);
        }
        if (currentTask.getId() > getIdGenerator()) {
            setIdGenerator(currentTask.getId() + 1);
        }
    }

    private static Task fromString(String value) {       // из каждой строки файла создаём новый объект задач
        String[] taskData = value.split(",");
        int id = Integer.parseInt(taskData[0]);
        TaskType tasksType = TaskType.valueOf(taskData[1]);
        String name = taskData[2];
        Status status = Status.valueOf(taskData[3]);
        String description = taskData[4];

        switch (tasksType) {
            case TASK:
                return new Task(id, name, description, status);
            case EPIC:
                return new Epic(id, name, description, status);
            case SUBTASK:
                int epicParentId = Integer.parseInt(taskData[5]);
                return new Subtask(id, name, description, status, epicParentId);
            default:
                return null;
        }
    }
}
