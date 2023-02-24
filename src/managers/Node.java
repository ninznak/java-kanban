package managers;

public class Node<Task> {
    private Node<Task> next;
    private Task data;
    private Node<Task> previous;

    public Node(Node<Task> previous, Task data, Node<Task> next) {
        this.previous = previous;
        this.data = data;
        this.next = next;
    }

    public Node<Task> getNext() {
        return next;
    }

    public Task getData() {
        return data;
    }

    public Node<Task> getPrevious() {
        return previous;
    }

    public void setNext(Node<Task> next) {
        this.next = next;
    }

    public void setData(Task data) {
        this.data = data;
    }

    public void setPrevious(Node<Task> previous) {
        this.previous = previous;
    }
}