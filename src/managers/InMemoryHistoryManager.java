package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {

    private List<Task> historyArray = new ArrayList<>();
    private List<Task> CustomLinkedList = new LinkedList<>();

    @Override
    public void addTask(Task task) {
        historyArray.add(task);

        if (historyArray.size() > 10) {
            historyArray.remove(0);
        }
    }

    @Override
    public void remove(int id){
        historyArray.remove(id);
    };

    @Override
    public List<Task> getHistory() {
        return historyArray;
    }
}
