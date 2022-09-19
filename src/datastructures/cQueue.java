/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Admin
 */
public class cQueue extends DataStructures
{
    private int[] arr;
    private int rear = -1;
    private int front = 0;
    private int size;
    
    public cQueue(int len)
    {
        size = len;
        arr = new int[size];
    }
    
    public void add(int num) throws queueException
    {
        if(isFull())
        {
            throw new queueException("The queue is full");
        }
        else
        {
            rear++;
            arr[rear % size] = num;
        }
    }
    
    public int remove() throws queueException
    {
        int item;
        if(isEmpty())
        {
            throw new queueException("The queue is empty");
        }
        else
        {
            item = arr[++front];
        }
        return item;
    }
    
    public boolean isEmpty()
    {
        return rear + 1 == front;
    }
    
    public boolean isFull()
    {
        return ((rear % size == size - 1 && front % size == 0) || rear % size == (front % size) - 1 && !isEmpty());
    }
    
    public void outputQueue()
    {
        if(front == -1)
        {
            System.out.print("Queue is Empty");
            return; //exits method
        }
        System.out.print("The elements in the circular queue are: \n");
        if(rear >= front)
        {
            for(int i = front; i <= rear; i++)  //prints front to rear
            {
                System.out.print(arr[i]);
                System.out.println(", ");
            }
        }
        else
        {
            for(int i = front; i < size; i++)   //loop from front pointer to max size/rear pointer
            {
                System.out.print(arr[i]);
                System.out.println(", ");
            }

            for(int i = 0; i <= rear; i++)
            {
                System.out.print(arr[i]);
                System.out.println(", ");
            }
        }
    }
}
