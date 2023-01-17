import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в основу программы \"Доска Kanban\".");

        Scanner scanner = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        TaskManager taskManager = new TaskManager();

        System.out.println("Меню программы: ");

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

                        Task task = new Task(taskName, taskDescription);
                        taskManager.newTasks.put(task.getId(), task);
                        System.out.println(task.getStatus());
                                /*Task task = new Task(taskName, taskDescription);
                                    System.out.println(task.getId());*/
                        System.out.println(Arrays.toString(taskDescription));
                    }
                case 0:
                    break;
            }

            /*if(command == 1){

            }*/
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
    }

    /*static void main(String[] args){
    }*/
}
