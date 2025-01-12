import java.util.Arrays;

public class logn {

    public static void main(String[] args) {
        int n = 1000000; 
        int[] sortedArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            sortedArray[i] = i + 1;
        }
        
        int target = n;
        
        long startTime = System.nanoTime();
        
        binarySearch(sortedArray, target);
        
        long endTime = System.nanoTime();
        
        long timeTaken = endTime - startTime;
        
        System.out.println("Time taken: " + timeTaken + " nanoseconds");
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (array[mid] == target) {
                return mid;
            }
            
            if (array[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        
        return -1;
    }
}
