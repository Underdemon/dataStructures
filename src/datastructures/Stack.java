/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author Admin
 */
public class Stack
{
    private int[] arr;
    private int maxSize;
    private int top;    //top of stack where objects can be pushed and popped
    
    public Stack(int size)
    {
        arr = new int[size];
        maxSize = size;
        top = -1;   //index of -1, so when an element is added, it can be incremented to an index of 0
    }
    
    /*
        Returns the size of the stack
    */
    public int currentSize()
    {
        return top + 1;
    }
    
    /*
        Returns whether the stack is full
    */
    public boolean isFull()
    {
        return currentSize() == maxSize;
        //return top == maxSize - 1;
    }
    
    /*
        Returns whether the stack is empty
    */
    public boolean isEmpty()
    {
        return currentSize() == 0;
        //return top == -1;
    }
    
    public void push(int num) throws stackException
    {
        if(this.isFull())
        {
            throw new stackException("Could not push from full stack");  //throwing an exception will exit the method
            //return; //method is void, so return statement is not expected. however, if a return method is given like so, it can be used to exit the method
        }
        arr[++top] = num;   //top's incremented value used as index for stack (top++ would mean the variables original value would be used as the index)
    }
    
    public int pop() throws stackException
    {
        if(this.isEmpty())
        {
            throw new stackException("Could not pop from empty stack");
        }
        return arr[top--];  //returns whatever is indexed at top and **then** decrements top
    }
    
    public int peek() throws stackException
    {
        if(this.isEmpty())
        {
            throw new stackException("Could not peek from empty stack");
        }
        return arr[top];  //returns whatever is indexed at top and **then** decrements top
    }
    
    public void outputArr()
    {
        //NOTE (in case needed): Arrays.deepToString(arr) is also a form of the function above but for multidimensional arrays
        ArrayList<String> stack = new ArrayList<String>();
        String j;
        //filters out null values in stack
        for(int i = 0; i < arr.length; i++)
        {
            j = Integer.toString(arr[i]);
            if(arr[i] != 0)
                stack.add(j);
            else
                stack.add("n/a");
        }
        System.out.println(stack);
    }
}


/*
    Methods to add: 
    •   push(int) //Adds an element to the top of the stack
    •   Int pop() //Removes the element from the top of the stack
    •   Int peek() //Returns the element from the top of the stack without removing it
    •   bool isEmpty()// True if the stack is empty
    •   bool isFull() // True if the stack is full
*/

/*
    incrementing i++ vs ++i and why ++i is usually better
    https://betterprogramming.pub/stop-using-i-in-your-loops-1f906520d548
    tldr:   i++ = int j = i; i = i + 1; return j;
            ++i = i = i + 1; return i;
    example of the difference between them: line 59 vs line 69
*/