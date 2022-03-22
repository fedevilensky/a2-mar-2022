#pragma once

#include "map.cpp"
#include <assert.h>

// esto es para poder usar hash y el equals
// seguramente tambien lo quieran usar para el hash cerrado
#include <functional>

#include <vector>

template <class K, class V, class Hash = std::hash<K>>
class OpenHashMap : public Map<K, V>
{
public:
  OpenHashMap(int expectedSize)
  {
    this->arrSize = expectedSize * 2 - 1;
    this->arr = new std::vector<Pair<K, V>> *[this->arrSize];
    this->elemCount = 0;
  }

  void insert(K key, V value) override
  {
    if (this->contains(key))
    {
      this->delete (key);
    }
    this->elemCount++;
    int pos = this->findPos(key);
    std::vector<Pair<K, V>> *list = this->arr[pos];
    if (vector == nullptr)
    {
      list = new std::vector<Pair<K, V>>();
      arr[pos] = list;
    }
    Pair p = new Pair(key, value);
    list->insert(p);
  }

  bool contains(K key) override
  {
    int pos = this->findPos(key);
    auto list = this->arr[pos];
    if (list == null)
    {
      return false;
    }
    Pair p = new Pair(key);
    // aca llamarian a su lista a preguntarle si tiene al par p
    for (Pair<K, V> other : list)
    {
      if (other == p)
      {
        return true;
      }
    }
    return false;
  }

  V get(K key) override
  {
    assert(this->contains(key));
    return V();
  }

  void delete (K key) override
  {
  }

  int size() override
  {
    return this.elemCount;
  }

  bool isEmpty() override
  {
    return this.elemCount == 0;
  }

private:
  Hash hashCode;
  // es una array de punteros a vectoras
  std::vector<Pair<K, V>> **arr;
  int arrSize;
  int elemCount;

  int findPos(K key)
  {
    int h = hashCode(key);
    int pos = h % this->arr.length;
    return pos;
  }
};

template <class K, class V, class Equals = std::equal_to<K>>
struct Pair
{
  K key;
  V value;

  Pair(K key, V value)
  {
    this->key = key;
    this->value = value;
  };

  Pair(K key)
  {
    this->key = key;
  }

  bool operator==(Pair<K, V> other)
  {
    return equals(this->key, other->key);
  }

private:
  Equals equals;
};
