#pragma once

template <class T, class K>
class Map
{
public:
  virtual void insert(K key, V value) = 0;

  virtual bool contains(K key) = 0;

  virtual V get(K key) = 0;

  virtual void delete (K key) = 0;

  /// devuelve la cantidad de elementos
  virtual int size() = 0;

  virtual bool isEmpty() = 0;
};
