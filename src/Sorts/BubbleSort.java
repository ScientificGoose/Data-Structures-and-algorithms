package Sorts;

public class BubbleSort {

    public BubbleSort(){}

    public int[] sort(int[] array){

        int size = array.length;

        for(int i = 0; i < size - 1; i++){
            boolean swapped = false;
            for(int j = 0; i < (size - i - 1); j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }
        return array;
    }
}
