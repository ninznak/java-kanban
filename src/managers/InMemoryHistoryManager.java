package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{

    @Override
    public void addTask(Task task) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<Task> getHistory() {
        return new ArrayList<>();
    }
}
