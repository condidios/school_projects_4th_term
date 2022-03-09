
public class Heap {
    /*
        → Comparable interface allows you to use the compareTo() method which is implemented in StudentGrade.java
        → You can easily call the compareTo() method to develop a more flexible code.
        → The compare to function is explained below:
        public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns
            • positive integer, if the current object is greater than the specified object.
            • negative integer, if the current object is less than the specified object.
            • zero, if the current object is equal to the specified object.
    */
    public static void maxHeapify(Comparable[] maxHeap, int n, int i) {
        int largest = i;

        int l = 2*i + 1;

        int r = 2*i + 2;

        if (l < n && maxHeap[l].compareTo(maxHeap[largest]) > 0)
            largest = l;


        if (r < n && maxHeap[r].compareTo(maxHeap[largest]) > 0)
            largest = r;


        if (largest != i)
        {
            Comparable swap = maxHeap[i];

            maxHeap[i] = maxHeap[largest];
            maxHeap[largest] = swap;

            maxHeapify(maxHeap, n, largest);
        }
    }

    public static void minHeapify(Comparable[] minHeap, int n, int i) {
        int smallest = i;

        int l = 2 * i + 1;

        int r = 2 * i + 2;

        if (l < n && minHeap[l].compareTo(minHeap[smallest]) < 0)
            smallest = l;


        if (r < n && minHeap[r].compareTo(minHeap[smallest]) < 0)
            smallest = r;


        if (smallest != i)
        {
            Comparable swap = minHeap[i];

            minHeap[i] = minHeap[smallest];
            minHeap[smallest] = swap;

            minHeapify(minHeap, n, smallest);
        }
    }
}
