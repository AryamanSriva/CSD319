import java.util.Arrays;
import java.util.Random;

public class nlogn {
    public static void main(String[] args) {
        int n = 1000000; 
        int[] array = generateRandomArray(n);

        long startTime = System.currentTimeMillis();

        Arrays.sort(array);

        long endTime = System.currentTimeMillis();

        long timeTaken = endTime - startTime;

        System.out.println("Time taken for n = " + n + " is: " + timeTaken + " ms");
    }

    private static int[] generateRandomArray(int n) {
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }
}
