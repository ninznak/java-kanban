import managers.InMemoryTaskManager;
import tasksTypes.Epic;
import tasksTypes.Status;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        InMemoryTaskManager taskManager = new InMemoryTaskManager();

        Task task1 = new Task("Задача Простая 1", "Купить молоко, Купить яйца, купить торт");
        taskManager.addNewTask(task1);
        Task task2 = new Task("Задача простая на воскресенье", "Повеселиться, Сходить в кино , спать");
        taskManager.addNewTask(task2);

        Epic epic1 = new Epic("1 Первая ЭПИЧНАЯ задача", "маленькое описание первого эпика");
        taskManager.addNewEpic(epic1);
        Subtask subtask1 = new Subtask("Подзадача новая", "Описание подзадачи");
        Subtask subtask2 = new Subtask("Подзадача новая 22 ", "Описание подзадачи 22 ");
        taskManager.addNewSubtask(epic1, subtask1);
        taskManager.addNewSubtask(epic1, subtask2);
        System.out.println(taskManager.getEpicTasks());

        Epic epic2 = new Epic("22 вторая ЭПИЧНАЯ задача", "маленькое описание эпика 22");
        taskManager.addNewEpic(epic2);
        Subtask subtask3 = new Subtask("Подзададача второ эпика", "Чтото нужно сделать, сделать еще");
        taskManager.addNewSubtask(epic2, subtask3);

        System.out.println(taskManager.getSimpleTasks());
        System.out.println(taskManager.getEpicTasks());
        System.out.println(taskManager.getSubtasks());
        System.out.println("");

        Task taskToUpdate = new Task("Задача Простая 1UPD", "Купить молокоNEW, Купить яйца, купить торт",
                Status.DONE);
        taskManager.updateTask(task2, taskToUpdate);

        Subtask subtaskUpd = new Subtask("Подзададача второ эпика",
                "Чтото нужно сделать, сделать еще", Status.DONE);
        taskManager.updateSubtask(subtask3, subtaskUpd);

        System.out.println(taskManager.getSimpleTasks());
        System.out.println(taskManager.getEpicTasks());
        System.out.println(taskManager.getSubtasks());

        taskManager.getTaskById(0);
        taskManager.getEpicById(2);
        taskManager.getSubtaskById(3);

        taskManager.getHistory();

        taskManager.deleteTaskById(1);
        taskManager.deleteEpicById(2);

        System.out.println(taskManager.getSimpleTasks());
        System.out.println(taskManager.getEpicTasks());
        System.out.println(taskManager.getSubtasks());
    }
}
