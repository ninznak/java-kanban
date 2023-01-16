import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Добро пожаловать в основу программы \"Доска Kanban\".");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Меню программы: ");

        while(true){
            printMenu();

            int command = scanner.nextInt();

            switch (command){
                case 1:
                    System.out.println("Формируем новую задачу!");
                    printMakeTaskMenu();
            }

            /*if(command == 1){

            }*/
        }
    }


    public static void printMenu() {
        System.out.println("Меню программы: ");
        System.out.println("1 <<-- занести новую задачу на доску");
        System.out.println("2 <<-- узнать идентефикатор задачи");
        System.out.println("3 <<-- вывести статус задачи");
    }

    public static void printMakeTaskMenu() {
        System.out.println("Меню внесения новой задачи: ");
        System.out.println("Введите имя задачи: ");
        System.out.println("2 <<-- вывести статус задачи");
    }
}
