import managers.FileBackedTasksManager;
import tasksTypes.Epic;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static managers.FileBackedTasksManager.loadFromFile;

public class Main {

    public static void main(String[] args) throws IOException {

        Path autosaveFileDirectory = Paths.get("C:/PracticumJava/java-kanban/data/");
        Path autosaveFile = Paths.get(autosaveFileDirectory.toString(), "save.csv");

        FileBackedTasksManager fileManager = null;

        loadFromFile(autosaveFile.toFile());

        System.out.println("*");
        fileManager.getEpicTasks();
        System.out.println("*");

        fileManager.addNewTask(new Task("Задача Простая 1", "Купить молоко, Купить яйца, купить торт"));
        fileManager.addNewTask(new Task("Задача простая2 на воскресенье", "Повеселиться, кино , спать"));

        System.out.println(fileManager.getSimpleTasks());
        fileManager.getTaskById(1);

        Epic epic1 = new Epic("1 Первая ЭПИЧНАЯ задача", "маленькое описание первого эпика");
        fileManager.addNewEpic(epic1);
        fileManager.getTaskById(0);
        fileManager.getEpicById(2);


        fileManager.addNewSubtask(epic1, new Subtask("Подзадача новая", "Описание подзадачи"));
        fileManager.addNewSubtask(epic1, new Subtask("Подзадача новая 22 ", "Описание подзадачи 22 "));
        fileManager.addNewSubtask(epic1, new Subtask("Подзадача очередная", "Описание" +
                " очередной подзадачи"));

        Epic epic2 = new Epic("22 вторая ЭПИЧНАЯ задача", "маленькое описание эпика 22");
        fileManager.addNewEpic(epic2);

        fileManager.getSubtaskById(4);
        fileManager.getSubtaskById(3);


        fileManager.getHistory();



        /*  SPRINT 5  taskManager.addNewTask(new Task("Задача Простая 1", "Купить молоко, Купить яйца, купить торт"));
        taskManager.addNewTask(new Task("Задача простая2 на воскресенье", "Повеселиться, кино , спать"));
        System.out.println(taskManager.getSimpleTasks());
        Epic epic1 = new Epic("1 Первая ЭПИЧНАЯ задача", "маленькое описание первого эпика");
        taskManager.addNewEpic(epic1);
        taskManager.addNewSubtask(epic1, new Subtask("Подзадача новая", "Описание подзадачи"));
        taskManager.addNewSubtask(epic1, new Subtask("Подзадача новая 22 ", "Описание подзадачи 22 "));
        taskManager.addNewSubtask(epic1, new Subtask("Подзадача очередная", "Описание" +
                " очередной подзадачи"));
        Epic epic2 = new Epic("22 вторая ЭПИЧНАЯ задача", "маленькое описание эпика 22");
        taskManager.addNewEpic(epic2);
        System.out.println("");
        taskManager.getTaskById(0);
        taskManager.getTaskById(1);
        taskManager.getEpicById(2);
        taskManager.getTaskById(1);
        taskManager.getEpicById(6);
        taskManager.getSubtaskById(3);
        taskManager.getTaskById(1);
        System.out.println(taskManager.getHistory());
        taskManager.deleteTaskById(1);
        System.out.println(taskManager.getHistory());
        taskManager.deleteEpicById(2);
        System.out.println(taskManager.getHistory());*/

    }
}