import java.io.File;
import java.util.*;
import java.util.jar.JarEntry;

public class Main {
    public static void main(String args[]) throws Exception {
        ArrayList<Integer> inputData = new ArrayList<>();
        Scanner scanner = new Scanner(new File(args[0]));
        while (scanner.hasNextInt()) {
            inputData.add(scanner.nextInt());
        }

        threeSum(inputData);
        System.out.println(threeSum(inputData));
    }

    public static int threeSum(ArrayList<Integer> inputData) {
        int count = 0;

        // Merge Sort instantiation
        MergeSort ms = new MergeSort(inputData);
        ms.mergeSortArray();
        inputData = ms.getSortedArray();

        // Binary search instantiation
        BinarySearch bs = new BinarySearch(inputData);

        // TODO: Your code here
        for (int i = 0; i < inputData.size(); i++) {
            for (int j = 0; j < inputData.size(); j++) {
                if(i != j){
                    int tempIndex = bs.getTargetIndexByBinarySearch(-(inputData.get(i) + inputData.get(j)));
                    if (tempIndex != -1 && inputData.get(i) < inputData.get(j) && inputData.get(j) < -(inputData.get(i) + inputData.get(j))) {
                        count++;
                    }
                }
            }

        }
        // For each pair of numbers a[i] and a[j]
        //      binary search for -(a[i] + a[j])
        //      only count if a[i] < a[j] < -(a[i] + a[j]) to avoid double counting

        return count;
    }
}
