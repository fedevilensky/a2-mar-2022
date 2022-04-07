#include "TAD/List.cpp"
#include <iostream>

int main()
{
  List<int> *list = new List<int>;
  for (int i = 0; i < 20; i++)
  {
    list->insert(i);
  }

  auto it = list->iterator();
  while (it->hasNext())
  {
    int elem = it->next();
    std::cout << elem << std::endl;
  }
}
