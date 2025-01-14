import java.util.Random;

public class MinMaxFinder {

    static class Pair {
        int min;
        int max;
    }

    public static Pair findMinMax(int[] arr) {
        Pair result = new Pair();
        int n = arr.length;
        int i = 0;

        if (n % 2 != 0) {
            result.min = arr[0];
            result.max = arr[0];
            i = 1; 
        } else {
            if (arr[0] < arr[1]) {
                result.min = arr[0];
                result.max = arr[1];
            } else {
                result.min = arr[1];
                result.max = arr[0];
            }
            i = 2; 
        }

        while (i < n - 1) {
            if (arr[i] < arr[i + 1]) {
                if (arr[i] < result.min) result.min = arr[i];
                if (arr[i + 1] > result.max) result.max = arr[i + 1];
            } else {
                if (arr[i + 1] < result.min) result.min = arr[i + 1];
                if (arr[i] > result.max) result.max = arr[i];
            }
            i += 2; 
        }

        return result;
    }

    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(1000) + 1; 
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sizes = {100000, 1000000, 10000000, 100000000};

        for (int size : sizes) {
            int[] arr = generateRandomArray(size);

            long startTime = System.currentTimeMillis();
            Pair minMax = findMinMax(arr);
            long endTime = System.currentTimeMillis();

            System.out.println("Array size: " + size);
            System.out.println("Minimum element: " + minMax.min);
            System.out.println("Maximum element: " + minMax.max);
            System.out.println("Time taken: " + (endTime - startTime) + " ms");
            System.out.println();
        }
    }
}
