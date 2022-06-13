package Hashes;

import LinearStructures.LinkedList;

import java.util.Objects;

/**
 * Hash table is an associative data structure that uses hashable keys and their associated values.
 * @param <K>
 * @param <V>
 */
public class HashTable<K, V> {

    /**
     * The hash node contains the Key and Value for the node. As well as the hashCode associated
     * with the key.
     * @param <K> A hashable object.
     * @param <V> The object associated with the key.
     */
    private class HashNode<K, V>{

        private K key;
        private V value;
        private int hashCode;
        private HashNode<K, V> next;

        /**
         * Default constructor for the hash node.
         * @param key The Object to be used as a key.
         * @param value The object associated with the key.
         */
        public HashNode(K key, V value){
            setKey(key);
            setValue(value);
            setHashCode(key);
        }

        /**
         * Set the key of the HashNode.
         * @param key A hashable object.
         */
        public void setKey(K key){
            this.key = key;
        }

        /**
         * Retrieve the key object.
         * @return The key of the HashNode.
         */
        public K getKey(){
            return key;
        }

        /**
         * The value associated with the Key object.
         * @param value The Object to be associated with te key.
         */
        public void setValue(V value){
            this.value = value;
        }

        /**
         * Retrieves the value of the HashNode.
         * @return The Object associated with the key.
         */
        public V getValue(){
            return value;
        }

        /**
         * generate the hash code of the key Object.
         * @param key The object to be hashed.
         */
        private void setHashCode(K key){
            this.hashCode = Objects.hashCode(key);
        }

        /**
         * Retrieve the hash code of the key object.
         * @return The hash value of the key.
         */
        public int getHashCode(){
            return this.hashCode;
        }
    }

    private int numberOfBuckets; // Initial size of array.
    private HashNode<K, V>[] bucketArray; // An array of HashNodes
    private int size;
    private int loadFactor;

    /**
     * Default Constructor for HashTable.
     */
    public HashTable(){
        numberOfBuckets = 10;
        bucketArray = new HashNode[numberOfBuckets];
        loadFactor = 7;
        size = 0;

        // Initialize array with null values.
        for(int i = 0; i < numberOfBuckets; i++){
            bucketArray[i] = null;
        }
    }

    /**
     * Returns the size of the HashTable.
     * @return An int value for the number of elements in the hash table.
     */
    public int getSize(){return size;}

    /**
     * Checks if the hash table contains elements.
     * @return A boolean value for if the table is empty.
     */
    public boolean isEmpty(){return size == 0;}

    /**
     * This method is called when the load factor threshold has been passed. It will
     * double the size of the array.
     */
    public void resize(){
        numberOfBuckets *= 2;
        HashNode<K, V>[] temp = bucketArray;
        System.arraycopy(temp, 0, bucketArray, 0, numberOfBuckets);
    }

    /**
     * Finds the index of the given hash code.
     * @param hashCode The hashcode of the key to be located in the hash table.
     * @return An int value for the index that will be assigned to the hash code.
     */
    private int getIndex(int hashCode){
        if(hashCode < 0){
            return (hashCode * -1) % numberOfBuckets;
        }
        return hashCode % numberOfBuckets;
    }

    /**
     * Add will check if the input key already exists in the HashTable the value will be updated
     * to the input value. If not, the key, value pair will be added to the table.
     * @param key A hashable object to be added to the map.
     * @param value The value to be associated to the key.
     */
    public void add(K key, V value){

        HashNode<K, V> temp = new HashNode<>(key, value);
        int index = getIndex(temp.getHashCode());

        HashNode<K, V> head = bucketArray[index];

        // Check if the key already exists in the hashtable. If it does, update the value.
        while(head != null){
            if(head.getKey().equals(key) && head.getHashCode() == temp.getHashCode()){
                head.setValue(value);
                return;
            }
            head = head.next;
        }
        size++;

        // Add the new node to the table.
        temp.next = head;
        bucketArray[index] = temp;

        // Check the if the load factor threshold has been passed. If so, resize the array.
        if((1.0 * size)/numberOfBuckets <= loadFactor){
            resize();
        }
    }

    /**
     * This will search the table for the given key. If found it will return the associated value,
     * otherwise it will return null.
     * @param key The hashable object to be searched for.
     * @return The value associated with the input key. Null, if they key doesn't exist.
     */
    public V get(K key){

        if(!isEmpty()){return null;}

        HashNode<K, V> temp = new HashNode<>(key, null);
        int index = getIndex(temp.getHashCode());

        HashNode<K, V> head = bucketArray[index];

        // Search the table for the key. If found, return the value.
        while(head != null){
            if(head.getKey() == temp.getKey() && head.getHashCode() == temp.getHashCode()){
                return temp.getValue();
            }
            head = head.next;
        }
        // Key does not exist in the table.
        return null;
    }

    /**
     * Searches the table for the input key, if found the Node containing the key will
     * be removed and its value returned.
     * @param key A hashable object to be searched for in the table.
     * @return If they key exists in the table the value will be returned, otherwise null will be returned.
     */
    public V remove(K key){
        if(!isEmpty()){return null;}

        HashNode<K, V> temp = new HashNode<>(key, null);
        int index = getIndex(temp.getHashCode());

        HashNode<K, V> head = bucketArray[index];
        HashNode<K, V> prev = null;
        // If the head of the linked list contains the key being searched for.
        if(head.getKey() == temp.getKey() && head.getHashCode() == temp.getHashCode()){
            bucketArray[index] = head.next;
        }
        // Search the table for the key. If found, return the value.
        while(head != null){
            if(head.next.getKey() == temp.getKey() && head.next.getHashCode() == temp.getHashCode()){
                break;
            }
            prev = head;
            head = head.next;
        }
        size--;

        // Remove the Node and return its value.
        if(prev != null){
            prev.next = head.next;
        } else{
            bucketArray[index] = head.next;
        }
        return head.value;
    }
}

