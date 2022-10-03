/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author rayan
 */
public class DL_Node<T>
{
    protected T data;
    protected DL_Node<T> next;
    protected DL_Node<T> prev;
    
    public DL_Node(T d, DL_Node<T> nextNode, DL_Node<T> prevNode)
    {
        this.data = d;
        this.next = nextNode;
        this.prev = prevNode;
        
        if(next != null)
            next.prev = this;
        
        if(prev != null)
            prev.next = this;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public DL_Node<T> getNext()
    {
        return next;
    }

    public void setNext(DL_Node<T> next)
    {
        this.next = next;
    }

    public DL_Node<T> getPrev()
    {
        return prev;
    }

    public void setPrev(DL_Node<T> prev)
    {
        this.prev = prev;
    }
    
    public DL_Node(T d)
    {
        this(d, null, null);
    }
}