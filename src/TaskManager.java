import java.util.HashMap;

public class TaskManager{
    private static int idGenerator;

    private static HashMap<Integer, Task> simpleTasks = new HashMap<>();
    private static HashMap<Integer, Epic> epicTasks = new HashMap<>();
    private static HashMap<Integer, Subtask> subtasks = new HashMap<>();


    public void addNewTask(Task obj) {           // added different types of tasks
        obj.setId(idGenerator++);
        simpleTasks.put(obj.getId(), obj);
    }

    public void addNewEpic(Epic epic) {
        epic.setId(idGenerator);
        epicTasks.put(idGenerator++, epic);
    }

    public void addNewSubtask(Epic epicParent, Subtask subtask) {
        subtask.setId(idGenerator++);
        subtask.setEpicParentId(epicParent.getId());
        //epicParent.subtasks.add(subtask);
        subtasks.put(subtask.getId(), subtask);
        epicParent.setStatus(StatusList.statusTask[1]);
    }

    public void getAllTasks() {                         // get all different types of tasks
        System.out.println("Все задачи Task: ");

        for (Object obj : simpleTasks.values()) {
            System.out.println(obj);
        }

        System.out.println("Все задачи Epic: ");
        for (Object obj : epicTasks.values()) {
            System.out.println(obj);
        }

        System.out.println("Все задачи SUBTASKS: ");
        for (Object obj : subtasks.values()) {
            System.out.println(obj);
        }
    }

    public void cleanTasks() {               // Tasks methods
        simpleTasks.clear();
    }

    public Task getTaskById(int id) {
        return simpleTasks.get(id);
    }

    public void updateTaskById(int taskId, Task updTask) {   // ?????????????????
        simpleTasks.put(updTask.getId(), new Task());
    }

    public void deleteTaskById(int id) {
        simpleTasks.remove(id);
        System.out.println("Задача Task" + " id#" + id + " удалена");
    }

    public void updateStatusOfTask(Task task, String newStatus) {
        task.setStatus(newStatus);
    }

    public void cleanAllEpics() {     // Epic methods
        System.out.println("Все задачи Epic и их подзадачи удалены");
        epicTasks.clear();
        subtasks.clear();
    }

    public void deleteEpicById(int id) {
        System.out.println("Задача EPIC id-" + id + " и её подзадачи удалены");
        epicTasks.remove(id);
        for (Subtask oldSubtask : subtasks.values()){
            if (oldSubtask.epicId == id){
                subtasks.remove(oldSubtask);
            }
        }
    }

    public Epic getEpicById(int id) {
        return epicTasks.get(id);
    }

    public void showEpicSubtasks(int idEpic){
        for (Subtask subtask : subtasks.values()){
            if(subtask.epicId == idEpic){
                System.out.println(subtask);
            }
        }
    }

    public void updateEpicById(Epic updEpic, Subtask newSubtask) {  //!!!!!!!!!!!!!!!!!!!!!!
        epicTasks.put(updEpic.getId(), new Epic());
    }

    public void updateStatusOfEpic(Epic epic, String newStatus) {
        if (true) {

        }
        epic.setStatus(newStatus);
    }

    public void cleanAllSubtasks() {                 //Subtask methods
        subtasks.clear();
        for (Epic epic : epicTasks.values()){
            epic.setStatus(StatusList.statusTask[0]);
        }
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public void getSubTasks(int getId) {
    }

    public void deleteSubtaskById(){

    }


}
