
public class sqrtn {
    public static void main(String[] args) {
        
        int n = 1000000;  
        
        long startTime = System.nanoTime();

        boolean isPrime = isPrime(n);

        long endTime = System.nanoTime(); 
        long timeTaken = endTime - startTime; 

        System.out.println("Time taken: " + timeTaken + " nanoseconds");
        
    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;   
        if (n <= 3) return true;   

        if (n % 2 == 0 || n % 3 == 0) return false;

        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }

        return true; 
    }
}
