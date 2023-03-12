import managers.FileBackedTasksManager;
import managers.Managers;
import managers.TaskManager;
import tasksTypes.Epic;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        TaskManager taskManager = Managers.getDefault();

        taskManager.addNewTask(new Task("Задача Простая 1", "Купить молоко, Купить яйца, купить торт"));
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

        Path path = Paths.get("save.txt");
        Files.deleteIfExists(path);
        //Files.createFile(Paths.get("save.txt"));

        String x = "fgfgdgddd";

        try {
            Files.createDirectory(Paths.get("C:\\PracticumJava\\java-kanban\\data\\"));
        } catch (IOException ex) {
            //ex.printStackTrace();
            //throw new IOException("чтото не то");
            System.out.println("Такая директория уже есть: " + ex.getCause());
        }

        try {
            FileBackedTasksManager newFile = new FileBackedTasksManager(Files.createFile(path).toFile());
        } catch (FileAlreadyExistsException ex) {
            System.out.println("Файл уже существует");
            throw new IOException(ex.getMessage());
        }



        System.out.println(taskManager.getHistory());

        taskManager.deleteTaskById(1);

        System.out.println(taskManager.getHistory());


        taskManager.deleteEpicById(2);

        System.out.println(taskManager.getHistory());

    }
}
