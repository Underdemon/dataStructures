/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author rayan
 * @param <K>
 * @param <V>
 */
public class hashTable<K, V>
{
    private static final int initial_capacity = 16;
    private int size = 0;
    private int slots;
    private hashEntry<K, V>[] buckets;
    private hashEntry<K, V> head, tail;
    
    public hashTable()
    {
        this(initial_capacity); //calls overloaded hashtable with slots = initial_capacity
    }
    
    public hashTable(int slots)
    {
        this.slots = slots;
        this.buckets = new hashEntry[slots];
    }
    
    
    
    public V item(K key) throws hashmapException     //returns value associated with key
    {
        int hash = hash(key);
        if(buckets[hash] == null)
            throw new hashmapException("Key not found");
        else
        {
            hashEntry<K, V> temp = buckets[hash];
            while(temp != null)
            {
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }
    
    public boolean containsKey(K key)     //returns t/f whether the key is in the hashtable
    {
        int hash = hash(key);
        if(buckets[hash] == null)
            return false;
        else
        {
            hashEntry<K, V> temp = buckets[hash];
            while(temp != null)
            {
                if(temp.key.equals(key))
                    return true;
                temp = temp.next;
            }
            return false;
        }
    }
    
    public int hash(K key)
    {
        return Math.abs(key.hashCode()) % slots;
    }
    
    
    
    public void addFirst(hashEntry<K, V> entry)
    {
        if(head == null)
        {
            head = tail = entry;
            return;
        }
        entry.after = head;
        head.prev = entry;
        head = entry;
    }
    
    public void add(K key, V value)
    {
        if(key == null) //no null valyes stored
            return;
        
        int hash = hash(key);
        hashEntry<K, V> entry = new hashEntry<>(key, value, null);
        insertOrder(entry);
        
        if(buckets[hash] == null)
            buckets[hash] = entry;
        else
        {
            hashEntry<K, V> previous = null;
            hashEntry<K, V> curr = buckets[hash];
            
            while(curr != null)
            {
                if(curr.key.equals(key))
                {
                    if(previous == null)
                    {
                        entry.next = curr.next;
                        buckets[hash] = entry;
                        return;
                    }
                    else
                    {
                        entry.next = curr.next;
                        previous.next = entry;
                        return;
                    }
                }
                
                previous = curr;
                curr = curr.next;
            }
            previous.next = entry;
        }
    }
    
    public void addLast(hashEntry<K, V> entry)
    {
        if(head == null)
        {
            head = tail = null;
            return;
        }
        tail.after = entry;
        entry.prev = tail;
        tail = entry;
    }
    
    public void addAfter(hashEntry<K, V> before, hashEntry<K, V> entry)
    {
        hashEntry<K, V> temp = head;
        while(temp != before)
            temp = temp.after;
        entry.after = before.after;
        before.after.prev = entry;
        entry.prev = before;
        before.after = entry;
    }
    
    public void insertOrder(hashEntry<K, V> entry)
    {
        if(head == null)
        {
            head = tail = entry;
            return;
        }
        
        else if(head.key.equals(entry.key))
        {
            deleteFirst();
            addFirst(entry);
            return;
        }
        
        else if(tail.key.equals(entry.key))
        {
            deleteLast();
            addLast(entry);
            return;
        }
        
        hashEntry<K, V> beforeDeletedEntry = deleteSpecific(entry);
        if(beforeDeletedEntry == null)
            addLast(entry);
        else
            addAfter(beforeDeletedEntry, entry);
    }
    
    
    
    public void deleteFirst()
    {
        if(head == tail)
        {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    
    public void delete(K delKey) throws hashmapException
    {
        int hash = hash(delKey);
        if(buckets[hash] == null)
            throw new hashmapException("Bucket does not exist (no key has been hashed to the bucket)");
        else
        {
            hashEntry<K, V> previous = null;
            hashEntry<K, V> curr = buckets[hash];
            
            while(curr != null)
            {
                if(curr.key.equals(delKey))
                {
                    deleteOrder(curr);
                    if(previous == null)
                    {
                        buckets[hash] = buckets[hash].next;
                    }
                    else
                    {
                        previous.next = curr.next;
                    }
                }
                previous = curr;
                curr = curr.next;
            }
            throw new hashmapException("Key does not exist");
        }
    }
    
    public void deleteLast()
    {
        if(head == tail)
        {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.after = null;
    }
    
    public hashEntry<K, V> deleteSpecific(hashEntry<K, V> entry)
    {
        hashEntry<K, V> temp = head;
        while(!temp.key.equals(entry.key))
        {
            if(temp.next == null)
                return null;
            temp = temp.next;
        }
        
        hashEntry<K, V> beforeIndex = temp.prev;
        temp.prev.after = temp.after;
        temp.after.prev = temp.prev;    //node ded
        return beforeIndex;
    }
    
    public void deleteOrder(hashEntry<K, V> delEntry)
    {
        if(head.key.equals(delEntry.key))
        {
            deleteFirst();
            return;
        }
        else if(tail.key.equals(delEntry.key))
        {
            deleteLast();
            return;
        }
        
        deleteSpecific(delEntry);
    }
    
    
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void outputHashTable()
    {
        System.out.println("\n   =========\n    HASHMAP\n   =========\n\n" + toString());
    }
    
    @Override
    public String toString()
    {
        /*
        String builder java page
            https://docs.oracle.com/javase/tutorial/java/data/buffers.html#:~:text=StringBuilder%20objects%20are%20like%20String,be%20changed%20through%20method%20invocations.
        */
        StringBuilder sb = new StringBuilder();
        hashEntry<K, V> entry = head;
        hashEntry<K, V> e = null;  //recursively search through complex data types and if hashEntry<K, V> is found, e = that hashentry's key/value
        if(entry.key.getClass().getSimpleName().equals(hashEntry.class.getName()))
        {
            e = (hashEntry<K, V>) entry.key;
        }
        if(entry.value.getClass().getSimpleName().equals(hashEntry.class.getName()))
        {
            e = (hashEntry<K, V>) entry.value;
        }
        else
        {
            e = entry;
        }
        sb.append("[");
        while (entry != null)
        {
            sb.append(e.key.toString()).append(" --> ").append(e.value.toString());
            if(entry.after != null)
                sb.append(", ");
            entry = entry.after;
        }
        sb.append("]");
        return "{" + sb.toString() + "}";
    }
}
/*
if(entry.key.getClass().equals(hashEntry.class))
        {
            e = (hashEntry<K, V>) entry.key;
        }
        if(entry.value.getClass().equals(hashEntry.class))
        {
            e = (hashEntry<K, V>) entry.value;
        }
        else
        {
            e = entry;
        }
*/