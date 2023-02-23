package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InMemoryHistoryManager implements HistoryManager {

    public CustomLinkedList<Task> customLinkedList = new CustomLinkedList<>();
    private Map<Integer, Node<Task>> historyHashMap = new HashMap<>();

    @Override
    public void addTask(Task task) {
        if(task != null){
            remove(task.getId());
            customLinkedList.linkLast(task);
        }
    }

    @Override
    public void remove(int id) {
        customLinkedList.removeNode(historyHashMap.get(id));
    }

    @Override
    public List<Task> getHistory() {
        return customLinkedList.getTasks();
    }

    protected class CustomLinkedList<T> {
        protected Node<Task> head;
        protected Node<Task> tail;
        public int size;

        private void linkLast(Task task) {
            size++;
            final Node<Task> oldTail = tail;
            final Node<Task> newTailNode = new Node<>(oldTail, task, null);
            historyHashMap.put(task.getId(), newTailNode);
            tail = newTailNode;
            if (oldTail == null) {
                head = newTailNode;
            } else {
                oldTail.next = newTailNode;
            }
        }

        private List<Task> getTasks() {
            List<Task> listOfTasks = new ArrayList<>();
            Node<Task> oneNode = head;
            while (oneNode != null) {
                listOfTasks.add(oneNode.data);
                oneNode = oneNode.next;
            }
            return listOfTasks;
        }

        private void removeNode(Node<Task> node) {

            if (size != 0) {
                if (size == 1) {
                    head = null;
                    tail = null;
                    size--;
                } else if (size == 2) {
                    if (node.previous == head) {
                        tail = null;
                        size--;
                    } else {
                        head = null;
                        size--;
                    }
                } else {
                    node.next.previous = node.previous.next;
                    node.previous.next = node.next.previous;
                    node.data = null;
                    size--;
                }
            }
        }
    }
}
