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
public class lQueue extends DataStructures
{
    private int[] arr;
    private int rear;
    private int front;
    
    public lQueue(int len)
    {
        arr = new int[len];
        rear = -1;
    }
    
    public void outputQueue()
    {
        if(isEmpty())
            System.out.println("\nQueue is empty\n");
        for(int i = front; i <= rear; i++)
        {
            System.out.println(arr[i]);
        }
    }
    
    public void add(int num) throws queueException
    {
        if(this.isFull())
            throw new queueException("The queue is full");
        else
        {
            arr[++rear] = num;
        }
    }
    
    public int remove() throws queueException
    {
        if(this.isEmpty())
            throw new queueException("The queue is empty");
        else
        {
            return arr[++front];
        }
    }
    
    public boolean isEmpty()
    {
        return rear == -1;
    }
    
    public boolean isFull()
    {
        return front == arr.length;
    }
}

/*
    add(int) //adds an element to the back of the queue
    int remove() //removes the element from the front of the queue
    bool isEmpty()
    bool isFull()
*/
