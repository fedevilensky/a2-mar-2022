package tads;

public class Heap<E, P extends Comparable<P>>
    implements PriorityQueue<E, P> {

  // private Pair<E,P>[] arr
  private Object[] arr;
  private int size;

  private class Pair {
    E elem;
    P prio;

    public Pair(E elem, P prio) {
      this.elem = elem;
      this.prio = prio;
    }
  }

  public Heap(int maxSize) {
    this.arr = new Object[maxSize + 1];
  }

  @Override
  public void push(E elem, P prio) throws Exception {
    if (this.isFull()) {
      throw new Exception("heap is full");
    }
    size++;
    arr[size] = new Pair(elem, prio);
    doFloat(size);
  }

  @Override
  public void pop() {
    if (size == 0) {
      return;
    }
    arr[1] = arr[size];
    size--;
    // hundir
    doSink(1);
  }

  @Override
  public E top() throws Exception {
    if (size == 0) {
      throw new Exception("heap is empty");
    }
    Pair p = (Pair) arr[1];
    return p.elem;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public boolean isFull() {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public int size() {
    return size;
  }

}
