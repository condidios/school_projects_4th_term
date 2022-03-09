import java.util.ArrayList;

public class BinarySearch {
    private int numberOfLookups = 0;
    private ArrayList<Integer> inputArray;

    public BinarySearch(ArrayList<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    public int getTargetIndexByBinarySearch(int target) {
        return binarySearch(target);
    }

    public int getNumberOfLookups() {
        return numberOfLookups;
    }

    public int binarySearch(int target) {

        //set the starting and ending indices
        int start = 0, ending = this.inputArray.size() - 1;
        int result = -1;

        while (start <= ending) {
            numberOfLookups++; // DO NOT DELETE THIS LINE!
            int mid = start + (ending - start) / 2;
            if (target < this.inputArray.get(mid)){
                ending = mid - 1;
            }
            else if (target > this.inputArray.get(mid)) {
                start = mid + 1;
            }
            else return mid;
            // TODO Your code here
            // take mid of the array
            // look for a match
            // go right if necessary or
            // go left if necessary
        }
        return result;
    }
}
