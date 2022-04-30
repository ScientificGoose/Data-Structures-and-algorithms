package Trees;

import java.util.Arrays;

public class MaxHeap {

    private int[] heapArray;
    int size;

    public MaxHeap(int maxSize){
        this.heapArray = new int[maxSize];
        this.size = 0;
    }

    public MaxHeap(int[] inputArray, int maxSize){
        this.heapArray = new int[maxSize];
        for(int i = 0; i < inputArray.length; i++){
            heapArray[i] = inputArray[i];
        }
        this.size = inputArray.length;
    }

    public int getSize(){return size;}

    public int[] getHeapAsArray(){
        int[] temp = new int[size];
        System.arraycopy(heapArray, 0, temp, 0, size);
        return temp;
    }

    public void insert(int element){
        heapArray[size] = element;

        int current = size;
        while(heapArray[current] > heapArray[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }
        size++;
    }

    private void swap(int firstIdx, int secondIdx){

        int temp;
        temp = heapArray[firstIdx];
        heapArray[firstIdx] = heapArray[secondIdx];
        heapArray[secondIdx] = temp;
    }

    public int getMax(){return 0;}

    public int extractMax(){return 0;}

    public void heapify(int index){

        if(isLeaf(index)){return;}

        if(heapArray[index] < heapArray[leftChild(index)] || heapArray[index] < heapArray[rightChild(index)]){
            if(heapArray[leftChild(index)] > heapArray[rightChild(index)]){
                swap(index, leftChild(index));
                heapify(leftChild(index));
            } else {
                swap(index, rightChild(index));
                heapify(rightChild(index));
            }
        }
    }

    private int parent(int index){return (index - 1) / 2;}

    private int leftChild(int index){return (2 * index) + 1;}

    private int rightChild(int index){return (2 * index) + 2;}

    private boolean isLeaf(int index){
        return (index > size / 2) && index <= size;
    }
}
