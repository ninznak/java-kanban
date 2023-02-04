package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private List<Task> historyArray = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        historyArray.add(task);

        if (historyArray.size() == 11) {
            historyArray.remove(0);
        }
    }

    @Override
    public List<Task> getHistory() {
        return historyArray;
    }
}
