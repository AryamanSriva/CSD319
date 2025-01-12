public class npown {
    private static long counter = 0;

    public static void generatePermutations(String currentString, int n, char[] alphabet) {
        if (currentString.length() == n) {
            counter++;
            return;
        }

        for (char c : alphabet) {
            generatePermutations(currentString + c, n, alphabet);
        }
    }

    public static void countPermutations(int n) {
        char[] alphabet = new char[n];
        for (int i = 0; i < n; i++) {
            alphabet[i] = (char) ('a' + i);  
        }

        counter = 0;
        generatePermutations("", n, alphabet);
    }

    public static void main(String[] args) {
        int n = 100;  

        long startTime = System.currentTimeMillis();
        countPermutations(n);
        long endTime = System.currentTimeMillis();

        System.out.println("Time taken: " + (endTime - startTime) + " milliseconds");
    }
}