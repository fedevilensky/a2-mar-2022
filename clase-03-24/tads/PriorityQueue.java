package tads;

public interface PriorityQueue<E, P extends Comparable<P>> {
  public void push(E elem, P prio) throws Exception;

  public void pop();

  public E top() throws Exception;

  public boolean isEmpty();

  public boolean isFull();

  public int size();
}
