import java.util.Arrays;

public class PigeonholeSort {

    public static void sort(int[] A)
    {
        int n = A.length;
        int min = A[0];
        int max = A[0];
        int range, i, j, index;

        for (int a = 0; a < n; a++) {
            if (A[a] > max)
                max = A[a];
            if (A[a] < min)
                min = A[a];
        }

        range = max - min + 1;
        int[] phole = new int[range];
        Arrays.fill(phole, 0);

        for (i = 0; i < n; i++)
            phole[A[i] - min]++;

        index = 0;

        for (j = 0; j < range; j++)
            while (phole[j]-- > 0)
                A[index++] = j + min;
    }
}
