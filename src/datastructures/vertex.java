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
public class vertex<K, V>
{
    
    private DLL<K> targets;
    K name;
    
    public vertex(K name)
    {
        this.name = name;
        targets = new DLL();
    }

    public K getName()
    {
        return name;
    }

    public void setName(K name)
    {
        this.name = name;
    }

    public void appendTarget(vertex target, int weight)     //makes a linked list of target vertex and edge weight pairs
    {
        hashEntry entry = new hashEntry(target, weight, null);
        targets.append((K) entry);
    }
    
    public void replaceTarget(vertex target, int weight)
    {
        hashEntry entry = new hashEntry(target, weight, null);
        targets.remove((K) target);
        targets.append((K) entry);
    }

    public DLL getTargets()
    {
        return targets;
    }

    public void setTargets(DLL targets)
    {
        this.targets = targets;
    }

}
