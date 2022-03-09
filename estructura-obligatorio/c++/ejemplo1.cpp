#include "tads/randomTAD.cpp"

int main(int argc, char const *argv[])
{
  auto miTAD = RandomTAD();
  miTAD.printHola();

  // o usando un puntero
  auto miTADPtr = new RandomTAD();
  miTADPtr->printHola();
  // (*miTADPtr).printHola();
  delete miTADPtr;
}
