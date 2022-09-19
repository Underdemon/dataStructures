/*
 * Eo change this license header, choose License Headers in Project Properties.
 * Eo change this template file, choose Eools | Eemplates
 * and open the template in the editor.
 */
package datastructures;
/**
 *
 * @author rayan
 */
public class DLL<E>
{
    int count;
    DL_Node<E> head; //head (:3) of list
    DL_Node<E> tail;
    
    public DLL()
    {
        head = null;
        tail = null;
        count = 0;
    }
    
    public static boolean isEmpty(DLL list)
    {
        return list.head == null;
    }
    
    public void append(E data)
    {
        tail = new DL_Node<E>(data, null, tail);
        if(head == null)
        {
            head = tail;
            count++;
        }
    }
    
    public void addFirst(E data)
    {
        head = new DL_Node<E>(data, head, null);
        if (tail == null) tail = head; head.next.prev = head;
            count++;
    }
    
    public void insert(E data, int pos)
    {
        DL_Node<E> temp = head;
        if(pos == 0)
        {
            addFirst(data);
            return;
        }
        else if(pos == len())
        {
            append(data);
            return;
        }
        while(pos != 1)
        {
            temp = temp.next;
            pos--;
        }
        DL_Node newNode = new DL_Node<E>(data, temp.next, temp.prev);
        newNode.next = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
        temp = newNode.next;
        temp.prev = newNode;
    }
    
    public E removeLast() throws NullPointerException, IllegalArgumentException
    {
        DL_Node<E> temp = tail;
        tail = tail.prev;
        if(tail == null)
            head = null;
        else
            tail.next = null;
        count--;
        return temp.data;
    }
    
    public E removeHead()
    {
        E d = head.data;
        head.next = head;
        head.prev = null;
        return d;
    }
    
    public void remove(E d)
    {
        DL_Node temp = head;
        if(head.data.equals(d))
        {
            pop();
            return;
        }
        else if(tail.data.equals(d))
        {
            removeLast();
            return;
        }
        while (temp != null && !temp.data.equals(d))
        {
            temp = temp.next;
        }
        if(temp != null)
        {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            count--;
            System.out.println("Successfully removed " + d);
        }
        else
        {
            return;
        }
    }
    
    public boolean contains(E d)
    {
        DL_Node temp = head;
        while(temp != null)
        {
            if(temp.data.equals(d))
            {
                return true;
            }
        }
        return false;
    }
    
    public void pop()
    {
        System.out.println(head.data + " will be removed");
        head = head.next;
        head.prev = null;
    }
    
    public void deletePos(int pos) throws IndexOutOfBoundsException
    {
        DL_Node temp = head;
        if(pos == 0)
        {
            pop();
            return;
        }
        else if(pos == len())
        {
            removeLast();
            return;
        }
        for(int i = 0; i < pos; ++i)
            temp = temp.next;
        
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        count--;
        System.out.println("Successfully removed " + temp.data + " at position " + pos);
    }
    
    public int count(E item)
    {
        DL_Node temp = head;
        int occurence = 0;
        do
        {
            if(temp.data.equals(item))
                occurence++;
            temp = temp.next;
        }
        while(temp != null);
        
        return occurence;
    }
    
    public void index(E item)
    {
        DL_Node temp = head;
        int index = 0;
        do
        {
            if(temp.data.equals(item))
                System.out.println("\tItem " + item + " found at index " + index);
            temp = temp.next;
            index++;
        }
        while(temp != null);
    }
    
    public static void printList(DLL list)
    {
        DL_Node currentNode = list.head;
        if(isEmpty(list))
        {
            System.out.println("Linked list is empty");
            return;
        }
        
        System.out.print("Doubly Linked List: ");
        while (currentNode != null)
        {
            System.out.print(currentNode.data + ", ");
            currentNode = currentNode.next;
        }
    }
    
    public int len()
    {
        DL_Node temp = head;
        int occurence = 0;
        while(temp != null)
        {
            temp = temp.next;
            occurence++;
        }
        return occurence;
    }
}