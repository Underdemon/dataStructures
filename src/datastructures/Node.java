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
public class Node
{
    //same as initialising new varibale hashEntry called data;
    //<editor-fold defaultstate="collapsed" desc="comment">
    hashEntry
//</editor-fold>
 data;
    Node next;
    
    public Node(hashEntry d)
    {
        data = d;
        next = null;
    }

    public hashEntry getData()
    {
        return data;
    }

    public void setData(hashEntry data)
    {
        this.data = data;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}