package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InMemoryHistoryManager implements HistoryManager {

    public CustomLinkedList<Task> customLinkedList = new CustomLinkedList<>();

    @Override
    public void addTask(Task task) {
        if (task != null) {
            remove(task.getId());
            customLinkedList.linkLast(task);
        }
    }

    @Override
    public void remove(int id) {
        customLinkedList.removeNode(id);
    }

    @Override
    public List<Task> getHistory() {
        System.out.println("Длина истории : " + customLinkedList.size + " шт.");
        return customLinkedList.getTasks();
    }

    private static class CustomLinkedList<T> {
        private Node head;
        private Node tail;
        private Map<Integer, Node<Task>> historyHashMap = new HashMap<>();
        public int size;

        private void linkLast(Task task) {
            final Node oldTail = tail;
            final Node newTailNode = new Node(oldTail, task, null);
            tail = newTailNode;
            historyHashMap.put(task.getId(), newTailNode);
            if (oldTail == null) {
                head = newTailNode;
            } else {
                oldTail.setNext(newTailNode);
            }
            size++;
        }

        private List<Task> getTasks() {
            List<Task> listOfTasks = new ArrayList<>();
            Node<Task> oneNode = head;

            while (oneNode != null) {
                listOfTasks.add(oneNode.getData());
                oneNode = oneNode.getNext();
            }
            return listOfTasks;
        }

        private void removeNode(int id) {
            Node<Task> node = historyHashMap.get(id);
            if (node != null) {
                if (head == node && tail == node) {
                    head = null;
                    tail = null;
                } else if (head == node) {
                    head = node.getNext();
                    head.setPrevious(null);
                } else if (tail == node) {
                    tail = node.getPrevious();
                    tail.setNext(null);
                } else {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }
                historyHashMap.remove(id);
                size--;
            }
        }
    }
}
