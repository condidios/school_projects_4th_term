import java.util.ArrayList;

public class InsertionSort {

    int[] sort(int[] A){
        int n = A.length;
        int[] output = A.clone();
        for (int i = 1; i < n; ++i) {
            int key = output[i];
            int j = i - 1;

            while (j >= 0 && output[j] > key) {
                output[j + 1] = output[j];
                j = j - 1;
            }
            output[j + 1] = key;
        }
        return output;
    }
}
