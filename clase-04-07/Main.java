import TAD.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> list = new List<Integer>();
    for (int i = 0; i < 20; i++) {
      list.insert(i);
    }

    System.out.println("while");
    var it = list.iterator();
    while (it.hasNext()) {
      Integer elem = it.next();
      System.out.println(elem);
    }

    System.out.println("\n\nforeach");
    for (Integer elem : list) {
      System.out.println(elem);
    }
  }
}
