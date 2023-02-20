package managers;

public class Node<T> {
    protected Node<T> next;
    protected T data;
    protected Node<T> previous;

    public Node(Node<T> previous, T data, Node<T> next) {
        this.previous = null;
        this.data = data;
        this.next = null;
    }
}