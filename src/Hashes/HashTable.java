package Hashes;

import LinearStructures.LinkedList;

import java.util.Objects;

public class HashTable<K, V> {

    private class HashNode<K, V>{

        private K key;
        private V value;
        private int hashCode;
        private HashNode<K, V> next;


        public HashNode(K key, V value){
            setKey(key);
            setValue(value);
            setHashCode(key);
        }

        public void setKey(K key){
            this.key = key;
        }

        public K getKey(){
            return key;
        }

        public void setValue(V value){
            this.value = value;
        }

        public V getValue(){
            return value;
        }

        private void setHashCode(K key){
            this.hashCode = Objects.hashCode(key);
        }

        public int getHashCode(){
            return this.hashCode;
        }
    }

    private int numberOfBuckets;
    private HashNode<K, V>[] bucketArray;
    private int size;
    private int loadFactor;

    public HashTable(){
        numberOfBuckets = 10;
        bucketArray = new HashNode[numberOfBuckets];
        loadFactor = 7;
        size = 0;

        for(int i = 0; i < numberOfBuckets; i++){
            bucketArray[i] = null;
        }
    }

    public int getSize(){return size;}
    public boolean isEmpty(){return size == 0}

    public void resize(){
        numberOfBuckets *= 2;
        HashNode<K, V>[] temp = bucketArray;
        System.arraycopy(temp, 0, bucketArray, 0, numberOfBuckets);
    }

    private int getIndex(int hashCode){
        int index;

        if(hashCode < 0){
            index = hashCode * -1;
        } else {
            index = hashCode;
        }
        return index % numberOfBuckets;
    }


    
}
