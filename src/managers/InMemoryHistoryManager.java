package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager{

    List<Task> historyArray = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        if(historyArray.size() < 10){
            historyArray.add(task);
        } else {
            historyArray.remove(0);
            historyArray.add(task);
        }
    }

    @Override
    public List<Task> getHistory() {
        return historyArray;
    }
}
