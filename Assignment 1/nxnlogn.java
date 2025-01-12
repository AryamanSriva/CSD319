import java.util.Arrays;

public class nxnlogn {

    public static void main(String[] args) {
        int n = 100000; 
        int[][] arr = generate2DArray(n);

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < n; i++) {
            Arrays.sort(arr[i]);
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        
        System.out.println("Time taken: " + duration + " ms");
    }

    private static int[][] generate2DArray(int n) {
        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 100); 
            }
        }
        return array;
    }
}
