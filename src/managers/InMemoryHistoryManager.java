package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InMemoryHistoryManager implements HistoryManager {

    private List<Task> historyArray = new ArrayList<>();
    private CustomLinkedList<Task> customLinkedList = new CustomLinkedList<>();
    private Map<Integer, Node<Task>> historyHashMap = new HashMap<>();

    @Override
    public void addTask(Task task) {
        customLinkedList.linkLast(task);
        /*historyArray.add(task);

        if (historyArray.size() > 10) {
            historyArray.remove(0);
        }*/
    }

    @Override
    public void remove(int id){
        historyArray.remove(id);
    };

    @Override
    public List<Task> getHistory() {
        return historyArray;
    }

    protected class CustomLinkedList<T>{
        protected Node<Task> head;
        protected Node<Task> tail;
        private int size;

        private void linkLast(Task task){
            size++;
            final Node<Task> oldTail = tail;
            final Node<Task> newTailNode = new Node<>(oldTail, task, null);
            tail = newTailNode;
            if (oldTail == null ){
                head = newTailNode;
            } else {
                oldTail.next = newTailNode;
            }

        }

        private List<Task> getTasks() {
            List<Task> listOfTasks = new ArrayList<>();
            return listOfTasks;
        }

        private void removeNode(Node<Task> node){
            size--;
            return;
        }
    }

}
