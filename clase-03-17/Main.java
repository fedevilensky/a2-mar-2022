import tads.ABBI;
import tads.AVL;
import java.lang.System;

public class Main {
  public static void main(String[] args) {
    ABBI<Integer> abb = new AVL<Integer>();
    System.out.printf("Altura del arbol: %d\n", abb.height());
    System.out.printf("#Elementos del arbol: %d\n", abb.size());

    abb.insert(42);
    abb.insert(24);
    abb.insert(12);
    System.out.printf("Altura del arbol: %d\n", abb.height());
    System.out.printf("#Elementos del arbol: %d\n", abb.size());

    System.out.printf("Elementos:\n");
    abb.inOrderPrint();

  }
}
