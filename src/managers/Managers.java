package managers;

import java.io.File;
import java.nio.file.Path;

public class Managers {

    public static HistoryManager getDefaultHistory() {
        return new InMemoryHistoryManager();
    }

    public static TaskManager getDefault() {
        return new InMemoryTaskManager();
    }

    public static FileBackedTasksManager getDefaultFile(String path){
        return new FileBackedTasksManager(new File(path));
    }
}
