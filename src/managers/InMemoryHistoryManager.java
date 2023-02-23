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
        if (task != null) {
            remove(task.getId());
            customLinkedList.linkLast(task);
        }
    }

    @Override
    public void remove(int id) {
        customLinkedList.removeNode(historyHashMap.remove(id));
    }

    @Override
    public List<Task> getHistory() {
        System.out.println("Длина истории : " + customLinkedList.size + " шт.");
        return customLinkedList.getTasks();
    }

    protected class CustomLinkedList<T> {
        private Node head;
        private Node tail;
        public int size;

        private void linkLast(Task task) {
            final Node oldTail = tail;
            final Node newTailNode = new Node(oldTail, task, null);
            tail = newTailNode;
            historyHashMap.put(task.getId(), newTailNode);
            if (oldTail == null) {
                head = newTailNode;
            } else {
                oldTail.next = newTailNode;
            }
            size++;
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

        private void removeNode(Node node) {

            if (node != null) {
                if (head == node && tail == node) {
                    head = null;
                    tail = null;
                } else if (head == node) {
                    head = node.next;
                    head.previous = null;
                } else if (tail == node) {
                    tail = node.previous;
                    tail.next = null;
                } else {
                    node.previous.next = node.next;
                    node.next.previous = node.previous;
                }
                size--;
            }
        }
    }
}
