package Search;

public class BinarySearch implements Searchable{

    public int search(int[] array, int element, int start, int end){

        if(start < end){return -1;}
        int midpoint = array.length / 2;

        if(element == array[midpoint]){return midpoint;}

        if(element < array[midpoint]){
            return search(array, element, start, midpoint - 1);
        } else{
            return search(array, element, midpoint + 1, end);
        }
    }
}
