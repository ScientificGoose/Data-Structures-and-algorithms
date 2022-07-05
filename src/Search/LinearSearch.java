package Search;

/**
 * Linear search is a search algorithm that searches the input array for the input value.
 */
public class LinearSearch implements Searchable {

    /**
     * Search will search the input array for the input object of type T.
     * @param array An array of objects of type T.
     * @param element The element to be searched for in the input array.
     * @return If element is found in array, return index in array. Otherwise return -1.
     */
    public int search(int[] array, int element, int start, int end){

        if(array.length == 0){return -1;}

        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] == element){
                return i;
            }
        }
        return -1;
    }
}
