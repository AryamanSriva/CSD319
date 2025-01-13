import java.io.*;

public class q2 {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter writer = new PrintWriter(System.out);
    static int n;
    static int[] matchedBolts;

    public static void main(String[] args) throws IOException {
        System.out.print("Enter the number of nuts and bolts: ");
        n = Integer.parseInt(reader.readLine());
        matchedBolts = new int[n + 1];
        
        for (int nut = 1; nut <= n; nut++) {
            int left = 1, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                int comparisonResult = compare(nut, mid);
                if (comparisonResult <= 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            matchedBolts[nut] = left;
        }
        
        System.out.println("Matching results:");
        for (int i = 1; i <= n; i++) {
            System.out.println("Nut " + i + " matches Bolt " + matchedBolts[i]);
        }
    }

    static int compare(int nut, int bolt) throws IOException {
        System.out.println("Compare Nut " + nut + " with Bolt " + bolt);
        System.out.print("Enter the result (< for smaller, > for larger, = for equal): ");
        String result = reader.readLine();
        if (result.equals("<")) return -1;
        if (result.equals(">")) return 1;
        return 0;
    }
}