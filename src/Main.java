import managers.Managers;
import managers.TaskManager;
import tasksTypes.Epic;
import tasksTypes.Status;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.io.IOException;

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

        //System.out.println(taskManager.getSimpleTasks());
        //System.out.println(taskManager.getEpicTasks());
        //System.out.println(taskManager.getSubtasks());
        taskManager.getTaskById(0);
        taskManager.getEpicById(1);
        taskManager.getEpicById(2);
        taskManager.getEpicById(6);
        System.out.println(taskManager.getHistory());
    }
}
