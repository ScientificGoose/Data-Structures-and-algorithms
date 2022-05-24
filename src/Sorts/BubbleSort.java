package Sorts;

public class BubbleSort {

    public BubbleSort(){}

    public int[] sort(int[] array){

        int iterations = 0;
        int size = array.length;

        for(int i = 0; i < size - 1; i++){
            for(int j = 0; i < size - iterations - 1; j++){
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                iterations += 1;
            }
        }
        return array;
    }
}
