import java.util.ArrayList;

public class MergeSort {
    private ArrayList<Integer> inputArray;
    private int numberOfMerges = 0;

    public ArrayList<Integer> getSortedArray() {
        return inputArray;
    }

    public int getNumberOfMerges() {
        return numberOfMerges;
    }

    public MergeSort(ArrayList<Integer> inputArray) {
        this.inputArray = inputArray;
    }

    public void mergeSortArray() {
        mergeSort(0, this.inputArray.size() - 1);
    }

    public void mergeSort(int startIndex, int endIndex) {

        if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
            // TODO Your code below
            int m = (endIndex+startIndex)/2;
            mergeSort( startIndex, m);
            mergeSort( m + 1, endIndex);
            merge(startIndex, endIndex);
        }
    }

    public void merge(int startIndex, int endIndex) {

        // DO NOT DELETE THIS LINE!
        numberOfMerges++;
        // New merged array for merging sorteded arrays Array[i-midIndex], Array[(midIndex+1)-endIndex]
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

        // TODO Your code below

        int leftIndex = startIndex;
        int midIndex =leftIndex+ (endIndex-startIndex)/2;
        int rightIndex = midIndex+1;

        while(leftIndex<=midIndex && rightIndex<=endIndex){
            if(inputArray.get(leftIndex)<=inputArray.get(rightIndex)){
                mergedSortedArray.add(inputArray.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(inputArray.get(rightIndex));
                rightIndex++;
            }
        }

        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(inputArray.get(leftIndex));
            leftIndex++;
        }

        while(rightIndex<=endIndex){
            mergedSortedArray.add(inputArray.get(rightIndex));
            rightIndex++;
        }

        int i = 0;
        int j = startIndex;


        //Setting sorted array to original one
        while (i < mergedSortedArray.size()) {
            inputArray.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
}