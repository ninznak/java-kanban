package managers;

import exceptions.ManagerSaveException;
import tasksTypes.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager implements TaskManager{

    private final File file;

    public FileBackedTasksManager (File file){
        this.file = file;
    }

    private void writeTasks(List<tasksTypes.Task> tasks, Writer writer) throws IOException {
        for (Task task : tasks) {
            writer.write(toCsvString(task) + "\n");
        }
    }

    private String toCsvString(Task task) {
        String type = TaskType.TASK.name();
        //String endOfString = "";
        if (task instanceof Epic) {
            type = TaskType.EPIC.name();
        } else if (task instanceof Subtask) {
            type = TaskType.SUBTASK.name();
            //endOfString += ((Subtask) task).getEpicId();
        }
        String csvString = task.getId() + "," +
                type + "," +
                task.getName() + "," +
                task.getStatus() + "," +
                task.getDescription();

        return csvString; //+ endOfString;
    }


    public void save() throws ManagerSaveException {
        try (Writer writer = new FileWriter((file),StandardCharsets.UTF_8)){
            writer.write("id,type,name,status, description, epic\n");
            writeTasks(get(), writer);
            writeTasks(getListOfEpics(), writer);
            writeTasks(getListOfSubtasks(), writer);
            writer.write("\n");
            writer.write(historyToString(historyManager));
        } catch (IOException e){
            throw  new ManagerSaveException ("Произошла ошибка записи");
        }
    }


    public static FileBackedTasksManager loadFromFile(File file) throws IOException {
        FileBackedTasksManager fileManager = new FileBackedTasksManager(file);

        try (BufferedReader brReader =  new BufferedReader(new FileReader((file), StandardCharsets.UTF_8))){
            brReader.readLine();
            while (brReader.ready()) {
                String line = brReader.readLine();
                //System.out.println(line);
                if (line.isEmpty()) {
                    List<Integer> history = historyFromString(brReader.readLine());
                    assert history != null;
                    fileManager.readHistory(history);
                    break;
                } else {
                    Task currentTask = fromString(line);
                    fileManager.readTasks(currentTask);
                }
            }
        }  catch (IOException exception) {
            System.out.println("Ошибка чтения файла.");
        }
        return fileManager;
    }

    public Task fromString(String value) {
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
                int epicId = Integer.parseInt(taskData[8]);
                return new Subtask(id, name, description, status, epicId);
            default:
                return null;
        }
    }

    static String historyToString(HistoryManager manager){
        List<String> taskIds = new ArrayList<>();

        for (Task task : manager.getHistory()) {
            taskIds.add(String.valueOf(task.getId()));
        }
        return String.join(",", taskIds);
    }

    static List<Integer> historyFromString(String value){
        if (value.isBlank()) {
            return null;
        } else {
            String[] idsString = value.split(",");

            List<Integer> tasksIds = new ArrayList<>();
            for (String idString : idsString) {
                tasksIds.add(Integer.valueOf(idString));
            }
            return tasksIds;
        }
    }

    @Override
    public List<Task> getHistory() throws ManagerSaveException {
        List<Task> task = super.getHistory();
        save();
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
    public List<Task> getSimpleTasks() throws ManagerSaveException {
        List<Task> tasks = super.getSimpleTasks();
        save();
        return tasks;
    }

    @Override
    public List<Epic> getEpicTasks() {
        List<Epic> epicTasks = super.getEpicTasks();
        return epicTasks;
    }

    @Override
    public List<Subtask> getSubtasks() throws ManagerSaveException {
        List<Subtask> subtasks = super.getSubtasks();
        save();
        return subtasks;
    }

    @Override
    public void cleanTasks() throws ManagerSaveException {
        super.cleanTasks();
        save();
    }

    @Override
    public Task getTaskById(int id) throws ManagerSaveException {
        Task task = super.getTaskById(id);
        save();
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
    public Epic getEpicById(int id) throws ManagerSaveException {
        save();
        return super.getEpicById(id);
    }

    @Override
    public void updateStatusEpic(Epic epic) throws ManagerSaveException {
        super.updateStatusEpic(epic);
        save();
    }

    @Override
    public List<Subtask> getEpicSubtasks(Epic epic) throws ManagerSaveException {
        List<Subtask> subtasks = super.getEpicSubtasks(epic);
        save();
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
    public Subtask getSubtaskById(int id) throws ManagerSaveException {
        Subtask subtask = super.getSubtaskById(id);
        save();
        return subtask;
    }

    @Override
    public void updateSubtask(Subtask oldSubtask, Subtask newSubtask) throws ManagerSaveException {
        super.updateSubtask(oldSubtask, newSubtask);
        save();
    }
}
