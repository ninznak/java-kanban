package managers;

import tasksTypes.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class InMemoryHistoryManager implements HistoryManager {

    private final CustomLinkedList customLinkedList = new CustomLinkedList();

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
        System.out.println("Длина истории : " + customLinkedList.historyHashMap.size());
        return customLinkedList.getTasks();
    }

    private static class CustomLinkedList {
        private Node head;
        private Node tail;
        private final Map<Integer, Node> historyHashMap = new HashMap<>();

        private void linkLast(Task task) {

            /*final Node oldTail = tail;            // более простая реализация
            final Node newTailNode = new Node(oldTail, task, null);
            tail = newTailNode;
            historyHashMap.put(task.getId(), newTailNode);
            if (oldTail == null) {
                head = newTailNode;
            } else {
                oldTail.setNext(newTailNode);
            }*/

            if (tail == null) {
                tail = head = new Node(null, task, null);
            } else {
                Node newTailNode = new Node(tail, task, null);
                tail.setNext(newTailNode);              // хвост начинает ссылаться на новый добавленный элемент
                tail = newTailNode;                     // старый хвост меняет себя на новую ноду
            }
            historyHashMap.put(task.getId(), tail);     // по итогам добавления в customList добавляем и в HashMap
        }

        private List<Task> getTasks() {
            List<Task> listOfTasks = new ArrayList<>();
            Node oneNode = head;

            while (oneNode != null) {
                listOfTasks.add(oneNode.getData());
                oneNode = oneNode.getNext();
            }
            return listOfTasks;
        }

        private void removeNode(int id) {
            Node node = historyHashMap.remove(id);

            if (node != null) {
                if (head.equals(node) && tail.equals(node)) {
                    head = null;
                    tail = null;
                } else if (head.equals(node)) {
                    head = node.getNext();
                    head.setPrevious(null);
                } else if (tail.equals(node)) {
                    tail = node.getPrevious();
                    tail.setNext(null);
                } else {
                    node.getPrevious().setNext(node.getNext());
                    node.getNext().setPrevious(node.getPrevious());
                }
            }
        }
    }
}
