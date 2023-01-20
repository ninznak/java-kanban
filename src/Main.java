import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        TaskManager taskManager = new TaskManager();

        Task task1 = new Task("Задача 1", "rexf, dfddfd,   dgdg,sfs");
        taskManager.addNewTask(task1);
        Task task2 = new Task("Zadacha2", "gjgjg, jhkjkkh,jhgjh,    jhgg ");
        taskManager.addNewTask(task2);

        Epic epic1 = new Epic();
        Subtask subtask1 = new Subtask("Subtaskname1 name", "Subdescription", epic1.getId());
        Subtask subtask2 = new Subtask(epic1.getId());

        Epic epic2 = new Epic();
        Subtask subtask3 = new Subtask(epic2.getId());


        taskManager.addNewTask(task1);
        taskManager.addNewTask(task2);
        taskManager.addNewEpic(epic1);
        taskManager.addNewEpic(epic2);

        System.out.println(taskManager.getNewTasks());

        System.out.println(epic2.getId());
        System.out.println(subtask2.getId());

        /*
        System.out.println("Добро пожаловать в основу программы \"Доска Kanban\".");

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TaskManager taskManager = new TaskManager();

        System.out.println("Меню программы: ");

        Subtask new222 = new Subtask(5){
        };

        while(true){
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Формируем новую задачу!");
                    printMakeTaskMenu();
                    int subCommand = scanner.nextInt();

                    if (subCommand == 1) {
                        String taskName;
                        String[] taskDescription;

                        System.out.println("<-- Введите данные новой задачи -->");
                        System.out.println("Введите название (заголовок) задачи");
                        taskName = bufferedReader.readLine();

                        System.out.println("Введите пункты задачи для выполнения через запятую: ");
                        taskDescription = WhitespaceDeleter.clean(bufferedReader.readLine().split(","));
                        System.out.println(Arrays.toString(taskDescription));
                    }
                case 0:
                    break;
            }
        }
    }


    public static void printMenu() {
        System.out.println("Главное меню программы: ");
        System.out.println("1 <<-- занести новую задачу на доску");
        System.out.println("2 <<-- резерв ... ");
        System.out.println("0 <<-- выход");
    }

    public static void printMakeTaskMenu() {
        System.out.println("Меню внесения новой задачи: ");
        System.out.println("1 <<-- Внести обычную задачу");
        System.out.println("2 <<-- Внести ЭПИК задачу (с подзадачами)");
    }*/

    }
}
