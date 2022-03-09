import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CountingSort {
    int[] sort(int[] A){
        int max = Arrays.stream(A).max().getAsInt();
        int min = Arrays.stream(A).min().getAsInt();
        int range = max - min + 1;
        int count[] = new int[range];
        int output[] = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            count[A[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = A.length - 1; i >= 0; i--) {
            output[count[A[i] - min] - 1] = A[i];
            count[A[i] - min]--;
        }

        return output;
    }
}
