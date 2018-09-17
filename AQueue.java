/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 */

class AQueue<E> implements Queue<E> {

  // Keep this non-private for testing purposes!
  E queueArray[]; // Array holding queue elements
  
  private static final int defaultSize = 10;
  private int front; // Index of front element
  private int size; // Number of elements stored.

  // Constructors
  @SuppressWarnings("unchecked") // Generic array allocation
  AQueue(int capacity) {
    queueArray = (E[]) new Object[capacity];
    front = 0;
    size = 0;
  }
  

  AQueue() {
    this(defaultSize);
  }

  // Reinitialize
  public void clear() {
    size = 0;
    front = 0;
    queueArray = (E[]) new Object[defaultSize];  
  }

  // Put "it" in queue
  public boolean enqueue(E it) {
    int posToAdd = (front + size) % queueArray.length;
    queueArray[posToAdd] = it;
    size++;
    return true;
    
  }

  // Remove and return front value
  public E dequeue() {
   E toRemove = queueArray[front];
   front = (front + 1) % queueArray.length;
   if(size > 0)
   {
     size--;
   }
   return toRemove;
  }

  // Return front value
  public E frontValue() {
    return queueArray[front];
  }

  // Return queue size
  public int length() {
    return size;
  }
}

