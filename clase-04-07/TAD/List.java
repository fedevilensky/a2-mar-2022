package TAD;

import java.util.Iterator;

public class List<T> implements Iterable<T> {
  private Node root;

  private class Node {
    public T data;
    public Node next;
  }

  public void insert(T elem) {
    Node newNode = new Node();
    newNode.data = elem;
    newNode.next = root;
    root = newNode;
  }

  @Override
  public Iterator<T> iterator() {
    return new ListIterator(root);
  }

  private class ListIterator implements Iterator<T> {
    private Node actual;

    @Override
    public boolean hasNext() {
      return actual != null;
    }

    @Override
    public T next() {
      T elem = actual.data;
      actual = actual.next;
      return elem;
    }

    public ListIterator(Node start) {
      actual = start;
    }

  }

}
