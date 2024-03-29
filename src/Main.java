import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class Main {
    public static void main(String[] args) throws IOException {

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        }

        int[] dataRandom = new int[records.size()];

        for (int i = 0; i < records.size(); i++)   {
            List<String> record = records.get(i);
            int len = record.size();
            dataRandom[i] = Integer.parseInt(record.get(len - 1));
        }

        int[] dataRandom5 = Arrays.copyOfRange(dataRandom, 0, 500);
        int[] dataRandom1k = Arrays.copyOfRange(dataRandom, 0, 1000);
        int[] dataRandom2k = Arrays.copyOfRange(dataRandom, 0, 2000);
        int[] dataRandom4k = Arrays.copyOfRange(dataRandom, 0, 4000);
        int[] dataRandom8k = Arrays.copyOfRange(dataRandom, 0, 8000);
        int[] dataRandom16k = Arrays.copyOfRange(dataRandom, 0, 16000);
        int[] dataRandom32k = Arrays.copyOfRange(dataRandom, 0, 32000);
        int[] dataRandom64k = Arrays.copyOfRange(dataRandom, 0, 64000);
        int[] dataRandom128k = Arrays.copyOfRange(dataRandom, 0, 128000);
        int[] dataRandom250k = Arrays.copyOfRange(dataRandom, 0, 250000);

        int[][] datumRandom = {dataRandom5, dataRandom1k, dataRandom2k, dataRandom4k, dataRandom8k,
                                dataRandom16k, dataRandom32k, dataRandom64k, dataRandom128k, dataRandom250k};

        int[] dataRev5 = insertionSortReverse(dataRandom5);
        int[] dataRev1k = insertionSortReverse(dataRandom1k);
        int[] dataRev2k = insertionSortReverse(dataRandom2k);
        int[] dataRev4k = insertionSortReverse(dataRandom4k);
        int[] dataRev8k = insertionSortReverse(dataRandom8k);
        int[] dataRev16k = insertionSortReverse(dataRandom16k);
        int[] dataRev32k = insertionSortReverse(dataRandom32k);
        int[] dataRev64k = insertionSortReverse(dataRandom64k);
        int[] dataRev128k = insertionSortReverse(dataRandom128k);
        int[] dataRev250k = insertionSortReverse(dataRandom250k);

        int[][] datumReversed = {dataRev5, dataRev1k, dataRev2k, dataRev4k, dataRev8k, dataRev16k, dataRev32k,
                                dataRev64k, dataRev128k, dataRev250k};


        int[][] datumSorted = new int[10][];

        double[] insertionRandomTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumRandom[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                datumSorted[j] = insertionSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            insertionRandomTime[j] = time / (double) 10;
        }

        double[] mergeRandomTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumRandom[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = mergeSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            mergeRandomTime[j] = time / (double) 10;
        }

        double[] countingRandomTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumRandom[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = countingSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            countingRandomTime[j] = time / (double) 10;
        }

        double[] insertionSortedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumSorted[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = insertionSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            insertionSortedTime[j] = time / (double) 10;
        }

        double[] mergeSortedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumSorted[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = mergeSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            mergeSortedTime[j] = time / (double) 10;
        }

        double[] countingSortedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumSorted[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = countingSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            countingSortedTime[j] = time / (double) 10;
        }

        double[] insertionReversedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumReversed[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = insertionSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            insertionReversedTime[j] = time / (double) 10;
        }

        double[] mergeReversedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumReversed[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = mergeSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            mergeReversedTime[j] = time / (double) 10;
        }

        double[] countingReversedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumReversed[j];
            double time = 0;
            for (int i = 0; i < 10; i++)    {
                double startTime = System.currentTimeMillis();
                int[] savedData = countingSort(data);
                double stopTime = System.currentTimeMillis();
                time += (stopTime - startTime);
            }
            countingReversedTime[j] = time / (double) 10;
        }

        double[] linearRandomTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumRandom[j];
            int low = 0;
            int high = data.length;
            double time = 0;
            for (int i = 0; i < 1000; i++)    {
                Random r = new Random();
                int random = r.nextInt(high-low) + low;

                int n = data[random];

                double startTime = System.nanoTime();
                int savedData = linearSearch(data, n);
                double stopTime = System.nanoTime();
                time += (stopTime - startTime);
            }
            linearRandomTime[j] = time / (double) 1000;
        }

        double[] linearSortedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumSorted[j];
            int low = 0;
            int high = data.length;
            double time = 0;
            for (int i = 0; i < 1000; i++)    {
                Random r = new Random();
                int random = r.nextInt(high-low) + low;

                int n = data[random];

                double startTime = System.nanoTime();
                int savedData = linearSearch(data, n);
                double stopTime = System.nanoTime();
                time += (stopTime - startTime);
            }
            linearSortedTime[j] = time / (double) 1000;
        }

        double[] binarySortedTime = new double[10];

        for (int j = 0; j < 10; j++)   {
            int[] data = datumSorted[j];
            int low = 0;
            int high = data.length;
            double time = 0;
            for (int i = 0; i < 1000; i++)    {
                Random r = new Random();
                int random = r.nextInt(high-low) + low;

                int n = data[random];

                double startTime = System.nanoTime();
                int savedData = binarySearch(data, n);
                double stopTime = System.nanoTime();
                time += (stopTime - startTime);
            }
            binarySortedTime[j] = time / (double) 1000;
        }

        System.out.println("\nRandom Input Data Timing Results in ms");

        System.out.print("Insertion sort: ");
        for (double i : insertionRandomTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Merge sort: ");
        for (double i : mergeRandomTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Counting sort: ");
        for (double i : countingRandomTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.println("\nSorted Input Data Timing Results in ms");

        System.out.print("Insertion sort: ");
        for (double i : insertionSortedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Merge sort: ");
        for (double i : mergeSortedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Counting sort: ");
        for (double i : countingSortedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.println("\nReversely Sorted Input Data Timing Results in ms");

        System.out.print("Insertion sort: ");
        for (double i : insertionReversedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Merge sort: ");
        for (double i : mergeReversedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Counting sort: ");
        for (double i : countingReversedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Linear search (random data): ");
        for (double i : linearRandomTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Linear search (sorted data): ");
        for (double i : linearSortedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");

        System.out.print("Binary search (sorted data): ");
        for (double i : binarySortedTime)    {
            System.out.print(i + " ");
        }
        System.out.println(" ");


        int[] inputAxis = {500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000, 250000};

//        Random Input Data Timing Results in ms

        double[][] yAxisRandom = new double[3][10];
        yAxisRandom[0] = insertionRandomTime;
        yAxisRandom[1] = mergeRandomTime;
        yAxisRandom[2] = countingRandomTime;
        showAndSaveChart(new String[]{"Tests on a random data", "Milliseconds", "Insertion Sort", "Merge Sort",
                "Counting Sort"}, inputAxis, yAxisRandom);

//        Sorted Input Data Timing Results in ms

        double[][] yAxisSorted = new double[3][10];
        yAxisSorted[0] = insertionSortedTime;
        yAxisSorted[1] = mergeSortedTime;
        yAxisSorted[2] = countingSortedTime;
        showAndSaveChart(new String[]{"Tests on a sorted data", "Milliseconds", "Insertion Sort", "Merge Sort",
                "Counting Sort"}, inputAxis, yAxisSorted);

//        Reversely sorted Input Data Timing Results in ms

        double[][] yAxisReversed = new double[3][10];
        yAxisReversed[0] = insertionReversedTime;
        yAxisReversed[1] = mergeReversedTime;
        yAxisReversed[2] = countingReversedTime;
        showAndSaveChart(new String[]{"Tests on a reversely sorted data", "Milliseconds", "Insertion Sort", "Merge Sort",
                "Counting Sort"}, inputAxis, yAxisReversed);

//        Search algorithms

        double[][] yAxisLinearRandom = new double[3][10];
        yAxisLinearRandom[0] = linearRandomTime;
        yAxisLinearRandom[1] = linearSortedTime;
        yAxisLinearRandom[2] = binarySortedTime;
        showAndSaveChart(new String[]{"Searching algorithms", "Nanoseconds", "Linear search random", "Linear search sorted",
                "Binary search sorted"}, inputAxis, yAxisLinearRandom);

    }

    public static void showAndSaveChart(String[] titles, int[] xAxis, double[][] yAxis) throws IOException {
        // Create Chart
        XYChart chart = new XYChartBuilder().width(800).height(600).title(titles[0])
                .yAxisTitle("Time in " + titles[1]).xAxisTitle("Input Size").build();

        // Convert x axis to double[]
        double[] doubleX = Arrays.stream(xAxis).asDoubleStream().toArray();

        // Customize Chart
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNE);
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);

        // Add a plot for a sorting algorithm
        chart.addSeries(titles[2], doubleX, yAxis[0]);
        chart.addSeries(titles[3], doubleX, yAxis[1]);
        chart.addSeries(titles[4], doubleX, yAxis[2]);

        // Save the chart as PNG
        BitmapEncoder.saveBitmap(chart, titles[0] + ".png", BitmapEncoder.BitmapFormat.PNG);

        // Show the chart
        new SwingWrapper(chart).displayChart();
    }

    public static int[] insertionSort(int[] inputArray) {
        for (int j = 1; j < inputArray.length; j++) {
            int key = inputArray[j];
            int i = j - 1;
            while (i >= 0 && inputArray[i] > key)    {
                inputArray[i+1] = inputArray[i];
                i--;
            }
            inputArray[i + 1] = key;
        }
        return inputArray;
    }

    public static int[] mergeSort(int[] inputArray) {
        int n = inputArray.length;
        if (n <= 1) {
            return inputArray;
        }
        int[] left = Arrays.copyOfRange(inputArray, 0, n/2);
        int[] right = Arrays.copyOfRange(inputArray, n/2, n);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right)  {
        int leftI = 0;
        int rightI = 0;

        int[] c = new int[left.length + right.length];

        int cI = 0;

        while (leftI < left.length && rightI < right.length)    {
            if (left[leftI] > right[rightI])    {
                c[cI] = right[rightI];
                rightI++;
            } else {
                c[cI] = left[leftI];
                leftI++;
            }
            cI++;
        }

        while (leftI < left.length)    {
            c[cI] = left[leftI];
            leftI++;
            cI++;
        }

        while (rightI < right.length)    {
            c[cI] = right[rightI];
            rightI++;
            cI++;
        }
        return c;
    }

    public static int findMax(int[] inputArray) {
        int max = inputArray[0];
        for (int i: inputArray) {
            if (max < i)    {
                max = i;
            }
        }
        return max;
    }
    public static int[] countingSort(int[] inputArray)  {
        int size = inputArray.length;

        int k = findMax(inputArray);
        int[] count = new int[k + 1];
        int[] output = new int[size];

        for (int key : inputArray) {
            count[key]++;
        }

        for (int i = 1; i <= k; i++) {
            count[i] += count[i - 1];
        }

        for (int i = size - 1; i >= 0; i--)  {
            int key = inputArray[i];
            count[key] = count[key] - 1;
            output[count[key]] = inputArray[i];
        }
        return output;
    }

    public static int linearSearch(int[] inputArray, int value)    {
        int size = inputArray.length;

        for (int i = 0; i < size; i++)  {
            if (inputArray[i] == value) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] sortedArray, int value)    {
        int low = 0;
        int high = sortedArray.length - 1;

        while ((high - low) > 1)  {
            int mid = (high + low) / 2;
            if (sortedArray[mid] < value)   {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if (sortedArray[low] == value) {
            return low;
        } else if (sortedArray[high] == value)  {
            return high;
        }
        return -1;
    }

    public static int[] insertionSortReverse(int[] inputArray)  {
        for (int j = 1; j < inputArray.length; j++) {
            int key = inputArray[j];
            int i = j - 1;
            while (i >= 0 && inputArray[i] < key)    {
                inputArray[i+1] = inputArray[i];
                i--;
            }
            inputArray[i + 1] = key;
        }
        return inputArray;
    }
}
