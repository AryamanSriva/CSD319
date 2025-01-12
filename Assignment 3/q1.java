import java.util.*;

public class q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int q = scanner.nextInt();

        int[] servingsRequired = new int[n];
        for (int i = 0; i < n; i++) {
            servingsRequired[i] = scanner.nextInt();
        }

        int[] batchServings = new int[q];
        for (int i = 0; i < q; i++) {
            batchServings[i] = scanner.nextInt();
        }

        int[] remainingServings = Arrays.copyOf(servingsRequired, n);

        int currentCustomer = 0;
        int customersLeft = n;

        for (int i = 0; i < q; i++) {
            int servings = batchServings[i];

            while (servings > 0 && customersLeft > 0) {
                if (remainingServings[currentCustomer] <= servings) {
                    servings -= remainingServings[currentCustomer];
                    remainingServings[currentCustomer] = servingsRequired[currentCustomer];  
                    currentCustomer++;
                    customersLeft--;

                    if (currentCustomer == n) {
                        currentCustomer = 0;
                    }
                } else {
                    remainingServings[currentCustomer] -= servings;
                    servings = 0;
                }
            }

            if (customersLeft == 0) {
                remainingServings = Arrays.copyOf(servingsRequired, n);
                customersLeft = n;
                currentCustomer = 0;
            }

            System.out.println(customersLeft);
        }

        scanner.close();
    }
}
