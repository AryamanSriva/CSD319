public class n {
    public static void main(String[] args) {
        int n = 1000000;

        long startTime = System.nanoTime();

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i;
        }

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println(duration + " nanoseconds");
    }
}
