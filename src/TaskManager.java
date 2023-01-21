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

    public void updateTask(Task task) {
        simpleTasks.put(task.getId(), task);
    }

    public void deleteTaskById(int id) {
        simpleTasks.remove(id);
        System.out.println("Задача Task " + " id#" + id + " удалена");
    }

    public void cleanAllEpics() {     // Epic methods
        System.out.println("Все задачи Epic и их подзадачи удалены");
        epicTasks.clear();
        subtasks.clear();
    }

    public void deleteEpicById(int id) {  //??????????????????????????????????
        System.out.println("Задача EPIC id-" + id + " и её подзадачи удалены");
        epicTasks.remove(id);
        /*for(HashMap.Entry<Integer, Subtask> subtaskToDelete : subtasks.entrySet()) {
            if (subtaskToDelete.getValue().getEpicParentId() == id) {
                  // subtaskToDelete.getKey()
            }
            subtasks.remove(3);
            subtasks.remove(4);*/
        for (int idToDelete : subtasks.keySet()){
            if (subtasks.get(idToDelete).getEpicParentId() == id){
                //deleteSubtaskById(idToDelete);
                //System.out.println(subtasks.get(idToDelete));
                subtasks.clear();
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

    public void updateEpic(Epic updEpic) {
        epicTasks.put(updEpic.getId(), updEpic);
    }

    public void cleanAllSubtasks() {                 //Subtask methods
        subtasks.clear();
        for (Epic epic : epicTasks.values()){
            epic.setStatus(StatusList.statusTask[0]);
        }
    }

    public void deleteSubtaskById(int id){
        subtasks.remove(id);
        System.out.println("Подзадача " + " id №" + id + " удалена");
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }

    public void subtaskUpdate(Subtask newSubtask){

    }

    public void deleteSubtaskById(){

    }


}
