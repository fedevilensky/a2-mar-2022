#include "tads/AVL.cpp"
#include <iostream>

int main(int argc, char const *argv[])
{
  ABBAbs<int> *abb = new AVL<int>();
  std::printf("Altura del arbol: %d\n", abb->height());
  std::printf("#Elementos del arbol: %d\n", abb->size());

  abb->insert(42);
  abb->insert(24);
  abb->insert(12);
  std::printf("Altura del arbol: %d\n", abb->height());
  std::printf("#Elementos del arbol: %d\n", abb->size());

  std::printf("Elementos:\n");
  abb->inOrderPrint();

  return 0;
}
