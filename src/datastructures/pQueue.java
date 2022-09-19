/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author Admin
 */
public class pQueue
{
    private int size;
    private ArrayList<Integer> arr = new ArrayList<Integer>();
    private boolean isAdded = false;
    private int temp;
    
    public pQueue(int len)
    {
        size = len; //max size limit
    }
    
    public void add(int item) throws queueException
    {
        if(!isFull())
        {
            if(isEmpty())
                arr.add(item);
            else
            {
                int i = 0;
                do
                {
                    if(i < arr.size())
                    {
                        if(arr.get(i) < item)
                        {
                            i++;
                        }
                        else
                        {
                            arr.add(i, item);
                            isAdded = true;
                        }
                    }
                    else
                    {
                        arr.add(item);
                        isAdded = true;
                    }
                }
                while(i <= arr.size() && !isAdded);
                
                isAdded = false;
            }
        }
        else
        {
            throw new queueException("The queue is full");
        }
    } 
    
    public int remove() throws queueException
    {
        if(!isEmpty())
        {
            temp = arr.get(0);
            arr.remove(0);
            return temp;
        }
        else
        {
            throw new queueException("The queue is empty");
        }
    }
    
    public boolean isEmpty()
    {
        return arr.size() == 0;
    }
    
    public boolean isFull()
    {
        return arr.size() >= size;
    }
    
    public int returnPos(int pos)
    {
        return arr.get(pos);
    }
    
    public void outputQueue()
    {
        System.out.println(arr.toString());
    }
}
