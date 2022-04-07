#pragma once

#include "Iterator.cpp"

template <class T>
class Iterable
{
public:
  virtual Iterator<T> *iterator() = 0;
};
