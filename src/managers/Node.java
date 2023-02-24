package managers;

import tasksTypes.Task;

public class Node {
    private Node next;
    private Task data;
    private Node previous;

    public Node(Node previous, Task data, Node next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public Task getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}