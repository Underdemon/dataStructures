/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.regex.Pattern;

/**
 *
 * @author rayan
 * @param <T>
 */
public class BST<T extends Comparable<T>>
{
    private DL_Node<T> root;
    private int size = 0;
    
    public BST(T rootData)
    {
        this.root = new DL_Node(rootData, null, null);
        this.size++;
    }
    
    public void insert(DL_Node temp, T value)
    {
        if(isNumeric(temp.getData().toString()))
        {
            if(Integer.parseInt(value.toString()) < Integer.parseInt(temp.getData().toString()))
            {
                if(temp.prev != null)
                    insert(temp.prev, value);
                else
                {
                    temp.prev = new DL_Node(value);
                    System.out.println(value.toString() + " inserted as the left child of " + temp.getData());
                    this.size++;
                }
            }
            else if(Integer.parseInt(value.toString()) > Integer.parseInt(temp.getData().toString()))
            {
                if(temp.next != null)
                    insert(temp.next, value);
                else
                {
                    temp.next = new DL_Node(value);
                    System.out.println(value.toString() + " inserted as the right child of " + temp.getData());
                    this.size++;
                }
            }
        }
        else
        {
            if(value.compareTo((T) temp.getData()) < 0)
            {
                if(temp.prev != null)
                    insert(temp.prev, value);
                else
                {
                    temp.prev = new DL_Node(value);
                    System.out.println(value.toString() + " inserted as the left child of " + temp.getData());
                    this.size++;
                }
            }
            else if(value.compareTo((T)temp.getData()) > 0)
            {
                if(temp.next != null)
                    insert(temp.next, value);
                else
                {
                    temp.next = new DL_Node(value);
                    System.out.println(value.toString() + " inserted as the right child of " + temp.getData());
                    this.size++;
                }
            }
        }
    }
    
    public DL_Node delete(DL_Node temp, T value)
    {
        if(root == null)
            return root;    // ensures a non-empty tree
        
        if(isNumeric(temp.getData().toString()))
        {
            if(Integer.parseInt(value.toString()) > Integer.parseInt(temp.getData().toString()))    // traverse to right child
            {
                temp.setNext(delete(temp.getNext(), value));
            }
            else if(Integer.parseInt(value.toString()) < Integer.parseInt(temp.getData().toString()))   // traverse to left child
            {
                temp.setPrev(delete(temp.getPrev(), value));
            }
            else    // target found
            {
                if(temp.getPrev() == null)
                {
                    return temp.getNext();
                }
                else if(temp.getNext() == null)
                {
                    return temp.getPrev();
                }
                temp.setData(minValue(temp.getNext()));
                temp.setNext(delete(temp.next, (T) temp.getData()));
            }
            return temp;
        }
        else
        {
            if(value.toString().compareTo(temp.getData().toString()) > 0)    // traverse to right child
            {
                temp.setNext(delete(temp.getNext(), value));
            }
            else if(value.toString().compareTo(temp.getData().toString()) < 0)   // traverse to left child
            {
                temp.setPrev(delete(temp.getNext(), value));
            }
            else    // target found
            {
                if(temp.getPrev() == null)
                {
                    return temp.getNext();
                }
                else if(temp.getNext() == null)
                {
                    return temp.getPrev();
                }
                temp.setData(minValue(temp.getNext()));
                temp.setNext(delete(temp.next, (T) temp.getData()));
            }
            return temp;
        }
    }
    
    public DL_Node search(DL_Node temp, T data)
    {
        if(temp.getData() == data)
            
    }
    
    private T minValue(DL_Node temp)
    {
        T minv = (T) temp.getData();
        while(temp.getPrev() != null)
        {
            minv = (T) temp.getPrev().getData();
            temp = temp.getPrev();
        }
        return minv;
    }
    
    public void preOrder(DL_Node temp)
    {
        if(temp != null)
        {
            System.out.println(temp.getData() + " ");
            preOrder(temp.prev);
            preOrder(temp.next);
        }
    }
    
    public void inOrder(DL_Node temp)
    {
        if(temp != null)
        {
            inOrder(temp.prev);
            System.out.println(temp.getData() + " ");
            inOrder(temp.next);
        }
    }
    
    public void postOrder(DL_Node temp)
    {
        if(temp != null)
        {
            postOrder(temp.prev);
            postOrder(temp.next);
            System.out.println(temp.getData() + " ");
        }
    }
    
    public void prettyPrint(DL_Node node, int level)
    {
        if(node == null)
             return;
        
        prettyPrint(node.getNext(), level+1);
        
        if(level != 0)
        {
            for(int i=0; i < level - 1; i++)
                System.out.print("|\t");
            System.out.println("|-------"+node.getData());
        }
        else
            System.out.println(node.getData());
        
        prettyPrint(node.getPrev(), level+1);
    }    
    
    public DL_Node getRoot()
    {
        return root;
    }

    public void setRoot(DL_Node root)
    {
        this.root = root;
    }
    
    public void printBFS()   //level order traversal
    {
        int h = height(root);
        for(int i = 0; i <= h; ++i)
            printCurrLevel(root, i);
    }
    
    public int height(DL_Node node)
    {
        if(node == null)
            return 0;
        else
        {
            int lheight = height(node.prev);
            int rheight = height(node.next);
            
            return Math.max(lheight, rheight) + 1;
        }
    }
    
    public int size(DL_Node node)
    {
        if(node == null)
            return 0;
        else
        {
            return size(node.getPrev()) + 1 + size(node.getNext());
        }
    }
    
    private void printCurrLevel(DL_Node node, int level)
    {
        if(node == null)
            return;
        if(level == 1)
            System.out.println(node.data + " ");
        else if(level > 1)
        {
            printCurrLevel(node.prev, level--);
            printCurrLevel(node.next, level--);
        }
    }
    
    public boolean isNumeric(String str)
    {
        // used as compareTo() compares values lexicographically and only strings should be compared that way
        // https://chortle.ccsu.edu/java5/Notes/chap92/ch92_2.html
        if(str.equals(null))
            return false;
        
        final Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        
        /*
        -?          determines if number starts with minus
        \d+         matches one or more digits
        (\.\d+)?    matches for decimal point and digits following
        */
        
        return pattern.matcher(str).matches();
    }
}

