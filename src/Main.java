import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Задача Простая 1", "Купить молоко, Купить яйца, купить торт");
        taskManager.addNewTask(task1);
        Task task2 = new Task("Задача простая на воскресенье", "Повеселиться, Сходить в кино , спать");
        taskManager.addNewTask(task2);

        Epic epic1 = new Epic("1 Первая ЭПИЧНАЯ задача");
        taskManager.addNewEpic(epic1);
        Subtask subtask1 = new Subtask("Подзадача новая", "Описание подзадачи");
        Subtask subtask2 = new Subtask("Подзадача новая 22 ", "Описание подзадачи 22 ");
        taskManager.addNewSubtask(epic1, subtask1);
        taskManager.addNewSubtask(epic1, subtask2);
        //taskManager.deleteEpicById(2);

        Epic epic2 = new Epic("22 вторая ЭПИЧНАЯ задача", "маленькое описание эпика 22");
        taskManager.addNewEpic(epic2);
        System.out.println(epic2);

        taskManager.getAllTasks();
        System.out.println("");
        taskManager.showEpicSubtasks(2);

        //taskManager.deleteEpicById(2);
        //taskManager.cleanAllSubtasks();

        //taskManager.getAllTasks();
        //taskManager.showEpicSubtasks(2);


/*        Epic epic2 = new Epic();  // "2 вторая эпичная задача"
        taskManager.addNewEpic(epic2);
        Subtask subtask3 = new Subtask(epic2.getId());
        taskManager.addNewSubtask(epic1, subtask3);

        taskManager.updateTask(task1);

        taskManager.getAllTasks();
        System.out.println("");

        System.out.println(taskManager.getTaskById(0));

        taskManager.getAllTasks();*/


    }
}
