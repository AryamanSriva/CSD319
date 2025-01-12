public class twopown {

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 100;

        long startTime = System.currentTimeMillis(); 
        int ans = fibonacci(n);
        long endTime = System.currentTimeMillis(); 
        double executionTimeMs = endTime - startTime;
        System.out.println("Execution time: " + executionTimeMs + " milliseconds");
    }
}
