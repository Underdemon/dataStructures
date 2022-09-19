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
public class genLQ<E>
{
    private DLL list = new DLL();
    
    public void add(E item)
    {
        list.append(item);
    }
    
    public E remove()
    {
        return (E) list.removeHead();
    }
    
    public boolean isEmpty()
    {
        return list.isEmpty(list);
    }
    
    public int size()
    {
        return list.len();
    }
    
    public void output()
    {
        list.printList(list);
    }
}
