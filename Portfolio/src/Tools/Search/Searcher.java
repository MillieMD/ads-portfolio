package Tools.Search;

public class Searcher{

    /**
     * If given array is sorted perform binary search, else perform sequential search
     * @param target object to find
     * @param array array to search
     * @param <E> a class that implements the comparable interface
     * @return index of target in array
     */
    public static <E extends Comparable<? super E>> int search(E target, E[] array){

        if(isSorted(array)){
            return binarySearch(0, array.length - 1, target, array);
        }

        return sequentialSearch(target, array);
    }

    /**
     * Binary search using recursion
     *
     * @param target object to locate
     * @param array array to search
     * @return index of target in array, -1 if target is not present
     */
    private static <E extends Comparable<? super E>> int binarySearch(int top, int bottom, E target, E[] array){

        if(top > bottom){
            int middle = (top + bottom)/2;

            if(array[middle] == target){
                return middle;
            }

            if(array[middle].compareTo(target) > 0){ // Greater than
                return(binarySearch(top,middle + 1, target, array));
            }

            if(array[middle].compareTo(target) < 0){ // Greater than
                return(binarySearch(middle - 1,bottom, target, array));
            }
        }

        return -1;
    }

    /**
     * Sequential search for object
     *
     * @param target object to locate
     * @param array array to search
     * @return index of target in array, -1 if target is not present
     */
    private static <E extends Comparable<? super E>> int sequentialSearch(E target, E[] array){

        for(int i = 0; i < array.length; i++){
            if(array[i] == target){
                return i;
            }
        }

        return -1;
    }

    /**
     * Identifies if a given array is sorted
     *
     * @param array Array to check
     * @param <E> A class which extends comparable - required for compareTo() method
     * @return True if sorted, false if any pair is unsorted
     */
    private static <E extends Comparable<? super E>> boolean isSorted(E[] array){

        boolean sorted = true;

        for(int i = 1; i < array.length; i++){
            if(array[i-1].compareTo(array[i]) > 0){

                sorted = false;
                break;
            }
        }

        return sorted;
    }


}
