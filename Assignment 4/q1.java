import java.util.*;

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int b = sc.nextInt(); 

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt(); 
        }

        int minVal = Arrays.stream(arr).min().getAsInt();
        int maxVal = Arrays.stream(arr).max().getAsInt();

        List<List<Integer>> buckets = new ArrayList<>(b);
        for (int i = 0; i < b; i++) {
            buckets.add(new ArrayList<>());
        }

        double bucketRange = (double)(maxVal - minVal + 1) / b;

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int)((arr[i] - minVal) / bucketRange);
            if (bucketIndex >= b) {
                bucketIndex = b - 1;  
            }
            buckets.get(bucketIndex).add(arr[i]);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        for (List<Integer> bucket : buckets) {
            System.out.print(bucket.size() + " ");  
            for (int val : bucket) {
                System.out.print(val + " "); 
            }
            System.out.println();
        }

        sc.close();
    }
}
