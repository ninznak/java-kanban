package managers;

import tasksTypes.Epic;
import tasksTypes.Subtask;
import tasksTypes.Task;

import java.io.File;
import java.util.List;

public class FileBackedTasksManager extends InMemoryTaskManager implements TaskManager{

    private final File file;

    public FileBackedTasksManager (File file){
        this.file = file;
    }

    @Override
    public List<Task> getHistory(){
        return null;
    }

    @Override
    public void addNewTask(Task obj){

    }

    @Override
    public void addNewEpic(Epic epic){

    }

    @Override
    public void addNewSubtask(Epic epicParent, Subtask subtask) {

    }

    @Override
    public List<Task> getSimpleTasks(){
        return null;
    }

    @Override
    public List<Epic> getEpicTasks() {
        return null;
    }

    @Override
    public List<Subtask> getSubtasks(){
        return null;
    }

    @Override
    public void cleanTasks(){

    }

    @Override
    public Task getTaskById(int id){
        return null;
    }

    @Override
    public void updateTask(Task task, Task newTask){

    }

    @Override
    public void deleteTaskById(int id){

    }

    @Override
    public void cleanAllEpics(){

    }

    @Override
    public void deleteEpicById(int id) {

    }

    @Override
    public Epic getEpicById(int id) {
        return null;
    }

    @Override
    public void updateStatusEpic(Epic epic) {

    }

    @Override
    public List<Subtask> getEpicSubtasks(Epic epic){
        return null;
    }

    @Override
    public void cleanAllSubtasks(){

    }

    @Override
    public void deleteSubtaskById(int id){

    }

    @Override
    public Subtask getSubtaskById(int id){
        return null;
    }

    @Override
    public void updateSubtask(Subtask oldSubtask, Subtask newSubtask){

    }
}
