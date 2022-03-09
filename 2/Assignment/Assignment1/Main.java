import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Main {
    static int[] reverse(int a[], int n)
    {
        int[] b = new int[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }
    public static void main(String args[]) throws IOException {

        // X axis data
        int[] inputAxis = {512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};

        // Create sample data for linear runtime
        double[][] yAxis = new double[2][10];
        yAxis[0] = new double[]{512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 251282};
        yAxis[1] = new double[]{300, 800, 1800, 3000, 7000, 15000, 31000, 64000, 121000, 231000};

        // Save the char as .png and show it
        //showAndSaveChart("Sample Test", inputAxis, yAxis);
        BufferedReader file = new BufferedReader(new FileReader(args[0]));
        int[] filesArrayList = new int[251282];
        CountingSort countingSort = new CountingSort();
        PigeonholeSort pigeonholeSort = new PigeonholeSort();
        InsertionSort insertionSort = new InsertionSort();
        MergeSort mergeSort = new MergeSort();

        int counter = 0;

        String filesString;
        while ((filesString = file.readLine()) != null){
            if (counter == 0){
                counter++;
                continue;
            }
            String[] filesLines = filesString.split(",");
            filesArrayList[counter] = (Integer.parseInt(filesLines[7]));
            counter++;
        }
        int[] deneme = new int[]{2,3,6,1,9,4,5};
        System.out.println(Arrays.toString(deneme));
        deneme = insertionSort.sort(deneme);
        System.out.println(Arrays.toString(deneme));
        deneme = reverse(deneme,deneme.length);
        System.out.println(Arrays.toString(deneme));
        deneme = insertionSort.sort(deneme);
        System.out.println(Arrays.toString(deneme));

        int[] first512 = Arrays.copyOfRange(filesArrayList,0,512);
        int[] first1024 = Arrays.copyOfRange(filesArrayList,0,1024);
        int[] first2048 = Arrays.copyOfRange(filesArrayList,0,2048);
        int[] first4096 = Arrays.copyOfRange(filesArrayList,0,4096);
        int[] first8192 = Arrays.copyOfRange(filesArrayList,0,8192);
        int[] first16384 = Arrays.copyOfRange(filesArrayList,0,16384);
        int[] first32768 = Arrays.copyOfRange(filesArrayList,0,32768);
        int[] first65536 = Arrays.copyOfRange(filesArrayList,0,65536);
        int[] first131072 = Arrays.copyOfRange(filesArrayList,0,131072);
        int[] first251281 = Arrays.copyOfRange(filesArrayList,0,251281);
        ArrayList<int[]> arrays = new ArrayList<>();
        ArrayList<int[]> sortedArrays = new ArrayList<>();
        ArrayList<int[]> reverseArrays = new ArrayList<>();
        arrays.add(first512);
        arrays.add(first1024);
        arrays.add(first2048);
        arrays.add(first4096);
        arrays.add(first8192);
        arrays.add(first16384);
        arrays.add(first32768);
        arrays.add(first65536);
        arrays.add(first131072);
        arrays.add(first251281);

        System.out.println("Random");
        double[][] timeRandom = new double[4][10];
        int counter1 = 0;
        for (int[] A: arrays) {

            long timeCounting = 0;
            long timePigeon = 0;
            long timeInsertion = 0;
            long timeMerge = 0;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                insertionSort.sort(A);
                long time2 = System.currentTimeMillis();
                timeInsertion += (time2-time1);
            }
            timeInsertion = timeInsertion/10;
            timeRandom[0][counter1] = timeInsertion;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                mergeSort.mergeSort(A);
                long time2 = System.currentTimeMillis();
                timeMerge += (time2-time1);
            }
            timeMerge = timeMerge/10;
            timeRandom[1][counter1] = timeMerge;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                pigeonholeSort.sort(A);
                long time2 = System.currentTimeMillis();
                timePigeon += (time2-time1);
            }
            timePigeon = timePigeon/10;
            timeRandom[2][counter1] = timePigeon;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                countingSort.sort(A);
                long time2 = System.currentTimeMillis();
                timeCounting += (time2-time1);
            }
            timeCounting = timeCounting/10;
            timeRandom[3][counter1] = timeCounting;
            System.out.println(timeInsertion + " " + timeMerge + " " + timePigeon + " " + timeCounting + "\n");
            counter1++;
        }
        for (int[] A: arrays){
            A = mergeSort.mergeSort(A);
            sortedArrays.add(A);
        }
        System.out.println("Sorted");

        double[][] timeSorted = new double[4][10];
        int counter2 = 0;
        for (int[] A: sortedArrays) {

            long timeCounting = 0;
            long timePigeon = 0;
            long timeInsertion = 0;
            long timeMerge = 0;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                insertionSort.sort(A);
                long time2 = System.currentTimeMillis();
                timeInsertion += (time2-time1);
            }
            timeInsertion = timeInsertion/10;
            timeSorted[0][counter2] = timeInsertion;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                mergeSort.mergeSort(A);
                long time2 = System.currentTimeMillis();
                timeMerge += (time2-time1);
            }
            timeMerge = timeMerge/10;
            timeSorted[1][counter2] = timeMerge;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                pigeonholeSort.sort(A);
                long time2 = System.currentTimeMillis();
                timePigeon += (time2-time1);
            }
            timePigeon = timePigeon/10;
            timeSorted[2][counter2] = timePigeon;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                countingSort.sort(A);
                long time2 = System.currentTimeMillis();
                timeCounting += (time2-time1);
            }
            timeCounting = timeCounting/10;
            timeSorted[3][counter2] = timeCounting;
            System.out.println(timeInsertion + " " + timeMerge + " " + timePigeon + " " + timeCounting + "\n");
            counter2++;
        }
        for (int[] A: sortedArrays){
            A = reverse(A,A.length);
            reverseArrays.add(A);
        }
        System.out.println("Reverse");
        double[][] timeReverse = new double[4][10];
        int counter3 = 0;
        for (int[] A: reverseArrays) {

            long timeCounting = 0;
            long timePigeon = 0;
            long timeInsertion = 0;
            long timeMerge = 0;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                insertionSort.sort(A);
                long time2 = System.currentTimeMillis();
                timeInsertion += (time2-time1);
            }
            timeInsertion = timeInsertion/10;
            timeReverse[0][counter3] = timeInsertion;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                mergeSort.mergeSort(A);
                long time2 = System.currentTimeMillis();
                timeMerge += (time2-time1);
            }
            timeMerge = timeMerge/10;
            timeReverse[1][counter3] = timeMerge;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                pigeonholeSort.sort(A);
                long time2 = System.currentTimeMillis();
                timePigeon += (time2-time1);
            }
            timePigeon = timePigeon/10;
            timeReverse[2][counter3] = timePigeon;
            for (int i = 0; i < 10; i++) {
                long time1 = System.currentTimeMillis();
                countingSort.sort(A);
                long time2 = System.currentTimeMillis();
                timeCounting += (time2-time1);
            }
            timeCounting = timeCounting/10;
            timeReverse[3][counter3] = timeCounting;
            System.out.println(timeInsertion + " " + timeMerge + " " + timePigeon + " " + timeCounting + "\n");
            counter3++;
        }
        showAndSaveChart("Random",inputAxis,timeRandom);
        showAndSaveChart("Sorted",inputAxis,timeSorted);
        showAndSaveChart("Reversed",inputAxis,timeReverse);
    }

    public static void showAndSaveChart(String title, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(title)
                .yAxisTitle("Time in Milliseconds").xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries("Insertion Sort", doubleX, yAxis[0]);
        chart.addSeries("Merge Sort", doubleX, yAxis[1]);
        chart.addSeries("Pigeonhole Sort", doubleX, yAxis[2]);
        chart.addSeries("Counting Sort", doubleX, yAxis[3]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, title + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }

}
