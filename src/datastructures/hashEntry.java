/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Admin
 * @param <T>
 */
public class hashEntry<K, V>
{

    protected K key;
    protected V value;
    protected hashEntry<K, V> next, prev, after;
    
    public hashEntry(K key, V value, hashEntry<K, V> next)
    {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    hashEntry(vertex trgt, int weight)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public K getKey()
    {
        return key;
    }

    public void setKey(K key)
    {
        this.key = key;
    }

    public V getValue()
    {
        return value;
    }

    public void setValue(V value)
    {
        this.value = value;
    }

    public hashEntry<K, V> getNext()
    {
        return next;
    }

    public void setNext(hashEntry<K, V> next)
    {
        this.next = next;
    }

    public hashEntry<K, V> getBefore()
    {
        return prev;
    }

    public void setBefore(hashEntry<K, V> before)
    {
        this.prev = before;
    }

    public hashEntry<K, V> getAfter()
    {
        return after;
    }

    public void setAfter(hashEntry<K, V> after)
    {
        this.after = after;
    }
}
