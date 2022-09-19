/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.util.Arrays;

/**
 *
 * @author rayan
 * @param <T>
 */
public class linkedList<T>
{
    Node head; //head (:3) of list
    
    public linkedList insert(linkedList list, hashEntry data)
    {
        Node newNode = new Node(data); //creates a new node holding data
        newNode.next = null;
        
        if (list.head == null)  //if linked list is empty
        {
            list.head = newNode;    //make thew newMode the head of the linked list
        }
        else
        {
            Node last = list.head;
            while (last.next != null)   //traverses to last node in linked list
            {
                last = last.next;   
            }
            last.next = newNode;    //inserts the newNode at the last node
        }
        
        return list;    //returns list by the head (ln 24/28)
    }
    
    public void remove(int key)     //delete node with the key
    {
        Node temp = head;
        Node previous = null;
        
        if(temp.data.getKey().equals(key))    //if the head of the linked list == to the key
        {
            head = temp.next;   //moves head to the next node
            return; //exits method
        }
        
        while(!temp.data.getKey().equals(key))     //searches for key to be deleted
        {
            previous = temp;    //keeps track of current node, since temp has to move to the next node
            temp = temp.next;
        }
        
        if(temp == null)    //if temp is still null (hasn't changed since initialisation, the key is not present)
            return;
        System.out.println("The removed value is " + temp.data.getValue());
        previous.next = temp.next;  //unlinks the node from the linked list
    }
    
    public static void printList(linkedList list)
    {
        Node currentNode = list.head;
        System.out.print("Linked List: ");
        
        
        while (currentNode != null)
        {
            System.out.print((currentNode.data.getKey().toString()) + " " + currentNode.data.getValue().toString() + "\n");  //prints the data at the current node
            currentNode = currentNode.next;   //current node is set to next node
        }
        //System.out.println(toString(list, false));        attempted using https://memorynotfound.com/generic-object-tostring-method-reflections-java/
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public boolean containsKey(int key)
    {
        if(isEmpty())
            return false;
        Node temp = head;
        Node previous = null;
        
        if(temp.data.getKey().equals(key))    //if the head of the linked list == to the key
            return true;
        
        while(!temp.data.getKey().equals(key))     //searches for key to be deleted
        {
            previous = temp;    //keeps track of current node, since temp has to move to the next node
            temp = temp.next;
        }
        
        return temp != null; //if temp is still null (hasn't changed since initialisation, the key is not present)
    }
    
    public String item(int key) throws hashmapException
    {
        if(!containsKey(key))
            throw new hashmapException("Key does not exist");
        Node temp = head;
        Node previous = null;
        
        if(temp.data.getKey().equals(key))    //if the head of the linked list == to the key
            return (String)temp.data.getValue();
        
        while(!temp.data.getKey().equals(key))//searches for key to be deleted
        {
            previous = temp;    //keeps track of current node, since temp has to move to the next node
            temp = temp.next;
        }
        
        //could be used below if containskey isnt implemented
        //if(temp == null)    //if temp is still null (hasn't changed since initialisation, the key is not present)
        //    throw new hashmapException("Key does not exist");
        return (String)temp.data.getValue();
    }
}
