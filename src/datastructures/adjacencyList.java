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


public class adjacencyList<K, V>
{
    
    private hashTable<K, V> adjMap;
    private boolean initialised = false;
    
    public adjacencyList(int minSize)
    {
        adjMap = new hashTable(minSize);
    }
    
    public void printList()
    {
        adjMap.outputHashTable();
    }
    
    public void add(K src, V trgt, int weight)
    {
        
    }
}