import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private static int idGenerator;
    private String[] statusList;

    private static HashMap<Integer, Object> simpleTasks = new HashMap<>();
    private static HashMap<Integer, Object> epicTasks = new HashMap<>();
    private static HashMap<Integer, Object> subtasks = new HashMap<>();


    public static HashMap<Integer, Object> getNewTasks() {
        return newTasks;
    }



    public void addNewTask(Task obj){
        obj.setId(idGenerator++);
        simpleTasks.put(obj.getId(), obj);
    }

    public void addNewEpic(Epic epic){
        epic.setId(idGenerator);
        epicTasks.put(idGenerator++, epic);
    }

    public void addNewSubtask(Epic epicParent,Subtask subtask){
        subtask.setId(idGenerator++);
        subtask.setEpicParentId(epicParent.getId());
        epicParent.subtasks.add(subtask);
        subtasks.put(subtask.getId(), subtask);
    }

    public void getAllTasks(){
        System.out.println("Все задачи Task: ");
        for (Object obj : simpleTasks.keySet()){
            System.out.println(simpleTasks.get(obj));
        }

        System.out.println("Все задачи Epic: ");
        for (Object obj : epicTasks.keySet()){
            System.out.println(epicTasks.get(obj));
        }

        System.out.println("Задачи со статусом DONE: ");
        for (Object obj : subtasks.keySet()){
            System.out.println(subtasks.get(obj));
        }
    }

    public void cleanAllTasks(){
        simpleTasks.clear();
    }

    public void cleanAllEpics(){
        epicTasks.clear();
    }

    public void cleanAllSubtasks(){
        subtasks.clear();

    }


    public String getObjById(int id){
        Object toFind = new Object();
        for (Object obj : newTasks.values()){
            if (obj == id){
                toFind = obj;
            };
        }

        System.out.println("Задачи со статусом IN_PROGRESS: ");
        for (Object obj : inProgressTasks.keySet()){
            System.out.println(inProgressTasks.get(obj));
        }

        System.out.println("Задачи со статусом DONE: ");
        for (Object obj : doneTasks.keySet()){
            System.out.println(doneTasks.get(obj));
        }
    }

    public void getSubTasks(int getId){

    }

    public void getDefenitId(int idOfTask){
    }

    public void deleteById(int idOfTask){
    }

    public void moveTaskProgress(){
    }

    public void updateTask(Task task){
    }

}
