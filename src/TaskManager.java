import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private static int idGenerator;
    private String[] statusList;

    private static HashMap<Integer, Task> simpleTasks = new HashMap<>();
    private static HashMap<Integer, Epic> epicTasks = new HashMap<>();
    private static HashMap<Integer, Subtask> subtasks = new HashMap<>();


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

    public void getAllTasks() {
        System.out.println("Все задачи Task: ");
        for (Object obj : simpleTasks.keySet()) {
            System.out.println(simpleTasks.get(obj));
        }

        System.out.println("Все задачи Epic: ");
        for (Object obj : epicTasks.keySet()) {
            System.out.println(epicTasks.get(obj));
        }

        System.out.println("Задачи со статусом DONE: ");
        for (Object obj : subtasks.keySet()) {
            System.out.println(subtasks.get(obj));
        }
    }

    public void cleanTasks() {               // Tasks methods
        simpleTasks.clear();
    }

    public Task getTaskById(int id) {
        return simpleTasks.get(id);
    }

    public void updateTaskById(Task updTask) {
        simpleTasks.put(updTask.getId(), new Task());
    }

    public void deleteTaskById(int id) {
        simpleTasks.remove(getTaskById(id));
    }

    public void updateStatusOfTask(Task task, String newStatus) {
        task.setStatus(newStatus);
    }

    public void cleanAllEpics() {            // Epic methods
        epicTasks.clear();
    }

    public Epic getEpicById(int id) {
        return epicTasks.get(id);
    }

    public void updateEpicById(Epic updEpic) {
        epicTasks.put(updEpic.getId(), new Epic());
    }

    public void deleteEpicById(int id) {
        epicTasks.remove(getEpicById(id));
    }

    public void updateStatusOfEpic(Epic epic, String newStatus) {
        if(true){

        }
        epic.setStatus(newStatus);
    }

    public void cleanAllSubtasks(){                 //Subtask methods
        subtasks.clear();
        for (Integer id : epicTasks.keySet()){
            epicTasks.get(id).subtasks.clear();
        }
    }

    public Subtask getSubtaskById(int id){
        return subtasks.get(id);
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
