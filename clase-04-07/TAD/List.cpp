#pragma once
#include "Iterable.cpp"

template <class T>
struct Node
{
  T data;
  Node *next = nullptr;
};

template <class T>
class ListIterator : public Iterator<T>
{
private:
  Node<T> *actual;

public:
  T next() override
  {
    T elem = actual->data;
    actual = actual->next;
    return elem;
  }

  bool hasNext() override
  {
    return actual != nullptr;
  }

  ListIterator(Node<T> *start)
  {
    actual = start;
  }
};

template <class T>
class List : public Iterable<T>
{
private:
  Node<T> *root = nullptr;

public:
  void insert(T elem)
  {
    Node<T> *newNode = new Node<T>;
    newNode->data = elem;
    newNode->next = root;
    root = newNode;
  }

  Iterator<T> *iterator()
  {
    return new ListIterator<T>(root);
  }
};
