/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;
import java.util.Scanner;
/**
 *
 * @author Admin
 */
public class DataStructures
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        int size;
        int choice = 0;
        int temp;   //used for push
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Do you want to use a stack or a queue?\n\tEnter 1 for stack\n\tEnter 2 for linear queue\n\tEnter 3 for circular queue\n\tEnter 4 for priority queue\n\tEnter 5 for a hashmap\n\tEnter 6 for a doubly linked list\n\tEnter 7 for a priority queue based on a DLL\n\tEnter 8 for an adjacency list\n\tEnter 9 for a binary tree");
        while(choice < 1 || choice > 9)
        {
            choice = validateInput("\nPlease enter one of the valid options");
        }
        switch(choice)
        {
            case 1:
                size = validateInput("Please enter the size of the stack: ");
                Stack stack = new Stack(size);
                do
                {
                    choice = validateInput("\nPlease enter the corresponding command for what you want to do with the stack: \n\n\t0 - outputArray() \toutputs the stack\n\t1 - push(int) \t//adds an element to the top of the stack\n\t2 - pop() \t//removes the element from the top of the stack\n\t3 - peek() \t//returns the element from the top of the stack without removing it\n\t4 - isEmpty() \t//returns if the stack is empty\n\t5 - isFull \t//returns if the stack is full\n\t6 - size() \t//returns the size of the stack\n\t7 - exit to the main menu");
                    switch (choice)
                    {
                        case 0:
                            stack.outputArr();
                            break;
                        case 1:
                            temp = validateInput("\nPlease input the value you want to push to the top of the stack: ");
                            try
                            {
                                stack.push(temp);
                            }
                            catch(stackException s)
                            {
                                System.out.println("Stack Overflow");
                            }
                            break;
                        case 2:
                            try
                            {
                                System.out.println("The element popped from the stack is " + stack.pop());
                            }
                            catch(stackException s)
                            {
                                System.out.println("Stack Underflow");
                            }
                            break;
                        case 3:
                            try
                            {
                                System.out.println("The element peeked from the stack is " + stack.peek());
                            }
                            catch(stackException s)
                            {
                                System.out.println("Stack Underflow");
                            }
                            break;
                        case 4:
                            if (stack.isFull())
                            {
                                System.out.println("The stack is empty");
                            } 
                            else
                            {
                                System.out.println("The stack is not empty");
                            }
                            break;
                        case 5:
                            if (stack.isEmpty())
                            {
                                System.out.println("The stack is full");
                            } 
                            else
                            {
                                System.out.println("The stack is not full");
                            }
                            break;
                        case 6:
                            System.out.println("The size of the stack is: " + stack.currentSize());
                            break;
                    }

                    if (choice == 7)
                    {
                        break;
                    }
                } 
                while(true);
                break;
        case 2:
            size = validateInput("Please enter the size of the queue: ");
            lQueue queue = new lQueue(size);
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the queue: \n\n\t0 - Output the queue\n\t1 - add(int)\n\t2 - remove()\n\t3 - isEmpty()\n\t4 - isFull()\n\t5 - exit to the main menu");
                switch(choice)
                {
                    case 0:
                        queue.outputQueue();
                        break;
                    case 1:
                        temp = validateInput("\nPlease input the value you want to add to the queue: ");
                        try
                        {
                            queue.add(temp);
                        }
                        catch(queueException q)
                        {
                            System.out.println("Queue Overflow");
                        }
                        break;
                    case 2:
                        try
                        {
                            System.out.println("The removed element from the queue is: " + queue.remove());
                        }
                        catch(queueException q)
                        {
                            System.out.println("Queue Underflow");
                        }
                        break;
                    case 3:
                        if(queue.isEmpty())
                        {
                            System.out.println("The queue is empty");
                        }
                        else
                        {
                            System.out.println("The queue is not empty");
                        }
                        break;
                    case 4:
                        if(queue.isFull())
                        {
                            System.out.println("The queue is full");
                        }
                        else
                        {
                            System.out.println("The queue is not full");
                        }
                        break;
                }
                if(choice == 5)
                    break;
            }
            while(true);
            break;
        case 3:
            size = validateInput("Please enter the size of the queue: ");
            cQueue cqueue = new cQueue(size);
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the queue: \n\n\t0 - Output the queue\n\t1 - add(int)\n\t2 - remove()\n\t3 - isEmpty()\n\t4 - isFull()\n\t5 - exit to the main menu");
                switch(choice)
                {
                    case 0:
                        cqueue.outputQueue();
                        break;
                    case 1:
                    temp = validateInput("\nPlease input the value you want to add to the queue: ");
                    try
                    {
                        cqueue.add(temp);
                    }
                    catch(queueException q)
                    {
                        System.out.println("Queue Overflow");
                    }
                    break;
                    case 2:
                    try
                    {
                        System.out.println("The removed element from the queue is: " + cqueue.remove());
                    }
                    catch(queueException q)
                    {
                        System.out.println("Queue Underflow");
                    }
                    case 3:
                    if(cqueue.isEmpty())
                    {
                        System.out.println("The queue is empty");
                    }
                    else
                    {
                        System.out.println("The queue is not empty");
                    }
                    break;
                    case 4:
                    if(cqueue.isFull())
                    {
                        System.out.println("The queue is full");
                    }
                    else
                    {
                        System.out.println("The queue is not full");
                    }
                    break;
                }
                if(choice == 5)
                    break;
            }
            while(true);
            break;
        case 4:
            size = validateInput("Please enter the size of the queue: ");
            pQueue pqueue = new pQueue(size);
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the queue: \n\n\t0 - Output the queue\n\t1 - add(int)\n\t2 - remove()\n\t3 - isEmpty()\n\t4 - isFull()\n\t5 - exit to the main menu");
                switch(choice)
                {
                    case 0:
                        pqueue.outputQueue();
                        break;
                        //comment
                    case 1:
                        temp = validateInput("\nPlease input the value you want to add to the queue: ");
                        try
                        {
                            pqueue.add(temp);
                        }
                        catch(queueException q)
                        {
                            System.out.println("Queue Overflow");
                        }
                        break;
                    case 2:
                        try
                        {
                            System.out.println("The removed element from the queue is: " + pqueue.remove());
                        }
                        catch(queueException q)
                        {
                            System.out.println("Queue Underflow");
                        }
                    case 3:
                        if(pqueue.isEmpty())
                        {
                            System.out.println("The queue is empty");
                        }
                        else
                        {
                            System.out.println("The queue is not empty");
                        }
                        break;
                    case 4:
                        if(pqueue.isFull())
                        {
                            System.out.println("The queue is full");
                        }
                        else
                        {
                            System.out.println("The queue is not full");
                        }
                    break;
                }
                if(choice == 5)
                    break;
            }
            while(true);
            break;
        case 5:
            size = validateInput("Please enter the size of the hashmap: ");
            hashTable hashmap = new hashTable(size);
            String value;
            String s;
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the hashmap: \n\n\t0 - Output the hashmap\n\t1 - add(Key, Value) - adds a key value pair\n\t2 - delete(Key) - removes the specified key value pair\n\t3 - isEmpty()\n\t4 - item(Key) - return value associated with key\n\t5 - contains(Key) - returns whether the key is in the hashmap\n\t6 - exit to the main menu");
                switch(choice)
                {
                    case 0:
                        hashmap.outputHashTable();
                        break;
                        //comment
                    case 1:
                        System.out.println("\nPlease input the key you want to add to the hashmap: ");
                        s = scanner.nextLine();
                        System.out.println("Please enter the value you want to add to the hashmap: ");
                        value = scanner.nextLine();
                        try
                        {
                            hashmap.add(s, value);
                        }
                        catch(hashmapException h)
                        {
                            System.out.println("Key has already been added");
                        }
                        break;
                    case 2:
                        System.out.println("\nPlease input the key you want to be deleted from the hashmap: ");
                        s = scanner.nextLine();
                        try
                        {
                            hashmap.delete(s);
                        }
                        catch(hashmapException h)
                        {
                            System.out.println("Key does not exist");
                        }
                        break;
                    case 3:
                        if(hashmap.isEmpty())
                        {
                            System.out.println("The hashmap is empty");
                        }
                        else
                        {
                            System.out.println("The hashmap is not empty");
                        }
                        break;
                    case 4:
                        System.out.println("\nPlease input the key you want to be find the corresponding value of: ");
                        s = scanner.nextLine();
                        try
                        {
                            System.out.println("The value is " + hashmap.item(s));
                        }
                        catch(hashmapException h)
                        {
                            System.out.println("Key does not exist");
                        }
                        break;
                    case 5:
                        System.out.println("\nPlease input the key you want to check is contained in the hashmmap: ");
                        s = scanner.nextLine();
                        try
                        {
                            if(hashmap.containsKey(s))
                            {
                                System.out.println("The key is in the hashmap!");
                            }
                            else
                                System.out.println("The key is not in the hashmap");
                        }
                        catch(hashmapException h)
                        {
                            System.out.println("Key does not exist");
                        }
                        break;
                }
                if(choice == 6)
                    break;
            }
            while(true);
            break;
        case 6:
            DLL list = new DLL();
            String item;
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the DLL: \n\n\t0 - Output the DLL\n\t1 - append(item)\n\t2 - remove(item)\n\t3 - count(item)\n\t4 - len()\n\t5 - index(item)\n\t6 - insert(pos, item)\n\t7 - pop()\n\t8 - deletePos(pos)\tindex starts at 0\n\t9 - removeLast\n\t10 - isEmpty\n\t11 - removeFirst\n\t12 - exit to the main menu");
                switch(choice)
                {
                    case 0:
                        list.printList(list);
                        break;
                    case 1:
                        System.out.println("Please input the value you want to add to the DLL");
                        item = scanner.nextLine();
                        list.append(item);
                        break;
                    case 2:
                        System.out.println("Please input the value you want to be removed from the list (only the first instance will be removed");
                        item = scanner.nextLine();
                        list.remove(item);
                        break;
                    case 3:
                        System.out.println("Please input the item you want to count the occurences of: ");
                        item = scanner.nextLine();
                        System.out.println("There were " + list.count(item) + " occunrences of the item " + item);
                        break;
                    case 4:
                        System.out.println("The length of the DLL is " + list.len());
                        break;
                    case 5:
                        System.out.println("Please input the item you want to index: ");
                        item = scanner.nextLine();
                        System.out.println("\n");
                        list.index(item);
                        break;
                    case 6:
                        System.out.println("Please input the item you want to insert: ");
                        item = scanner.nextLine();
                        choice = validateInput("Please enter the index you want to add the item to: ");
                        list.insert(item, choice);
                        break;
                    case 7:
                        list.pop();
                        break;
                    case 8:
                        choice = validateInput("Please input the index you want to be removed from the linked list");
                        list.deletePos(choice);
                        break;
                    case 9:
                        System.out.println("The value removed from the list is: " + list.removeLast());
                        break;
                    case 10:
                        if(list.isEmpty(list))
                            System.out.println("The list is empty");
                        else
                            System.out.println("The list is not empty");
                        break;
                    case 11:
                        list.pop();
                        break;
                }
                if(choice == 12)
                    break;
            }
            while(true);
            break;
        case 7:
            DLL_pQueue pQueue = new DLL_pQueue();
            String data;
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the DLL based priority queue: \n\n\t0 - Output the pQueue\n\t1 - add(item)\n\t2 - pop()\n\t3 - remove(data)\n\t4 - isEmpty()\n\t5 - exit to main menu");
                switch(choice)
                {
                    case 0:
                        pQueue.printQueue();
                        break;
                    case 1:
                        System.out.println("Please input the data you want to add: ");
                        data = scanner.nextLine();
                        pQueue.enqueue(data);
                        break;
                    case 2:
                        System.out.println("The popped data is: " + pQueue.pop());
                        break;
                    case 3:
                        System.out.println("Please input the data you want to remove: ");
                        data = scanner.nextLine();
                        pQueue.remove(data);
                        break;
                    case 4:
                        if(pQueue.isEmpty())
                            System.out.println("The queue is empty");
                        else
                            System.out.println("The queue is not empty");
                        break;
                }
                if(choice == 12)
                    break;
            }
            while(true);
            break;
        case 8:
            size = validateInput("Please enter the number of nodes: ");
            adjacencyList adj = new adjacencyList(size);
            String input;
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the adjacencyList: \n\n\t0 - Output the adjList\n\t1 - insert(vertex source, vertex target, int weight\n\t2 - exit to main menu");
                switch(choice)
                {
                    case 0:
                        adj.printList();
                        break;
                    case 1:
                        System.out.println("Please input the source node you want to add: ");
                        input = scanner.nextLine();
                        System.out.println("Please input the target node you want to add: ");
                        data = scanner.nextLine();
                        choice = validateInput("Please input the weight between nodes: ");
                        adj.add(input, data, choice);
                        break;
                }
                if(choice == 2)
                    break;
            }
            while(true);
            break;
        case 9:
            System.out.println("Please enter the value of the root node: ");
            input = scanner.nextLine();
            BST tree = new BST(input);
            do
            {
                choice = validateInput("\nPlease enter the corresponding command for what you want to do with the binary tree: \n\n\t0 - insert\n\t1 - output preOrder\n\t2 - output inOrder\n\t3 - output postOrder\n\t4 - prettyPrint\n\t5 - BFS\n\t6 - exit to main menu");
                switch(choice)
                {
                    case 0:
                        System.out.println("Please input the value you want to add to the binary tree: ");
                        input = scanner.nextLine();
                        tree.insert(tree.getRoot(), input);
                        break;
                    case 1:
                        System.out.println("\n");
                        tree.preOrder(tree.getRoot());
                        break;
                    case 2:
                        System.out.println("\n");
                        tree.inOrder(tree.getRoot());
                        break;
                    case 3:
                        System.out.println("\n");
                        tree.postOrder(tree.getRoot());
                        break;
                    case 4:
                        System.out.println("\n");
                        tree.prettyPrint(tree.getRoot(), 0);
                    case 5:
                        System.out.println("\n");
                        tree.printBFS();
                }
                if(choice == 6)
                    break;
            }
            while(true);
            break;
        }
        System.out.println("Thanks for using the program!");
    }

    public static int validateInput(String message)
    {
        Scanner scanner = new Scanner(System.in);
        String inputChoice;
        int choice = 0;
        
        System.out.println(message);
        inputChoice = scanner.nextLine();
        try
        {
            //wrapping parseInt in try catch in case an int was not entered
            choice = Integer.parseInt(inputChoice);
        } 
        catch (NumberFormatException x)
        {
            //provides details on the exception that is thrown and also provides a more concise, readable error message
            System.out.println("\n" + x + "\n\nYou have entered an illegal value, please provide a valid input\n");
            //isIllegalInput = true;
            return validateInput(message);
        }
        return choice;
    }
}
