import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    private static int idGenerator;

    public  HashMap<Integer, Object> newTasks = new HashMap<>();
    public static HashMap<Integer, Epic> inProgressTasks = new HashMap<>();
    public static HashMap<Integer, Epic> doneTasks = new HashMap<>();

    public static HashMap<Integer, Task> NEW = new HashMap<>();

    public void updateTask(Task task){
    }

    public static int getIdGenerator() {
        return idGenerator;
    }
}
