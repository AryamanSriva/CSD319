public class nxn {

    public static void main(String[] args) {
        int n = 1000000; 
        int[] array = generateRandomArray(n);

        long startTime = System.currentTimeMillis();

        bubbleSort(array);

        long endTime = System.currentTimeMillis(); 

        long duration = endTime - startTime; 

        
        System.out.println(duration); 
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * 10000); 
        }
        return array;
    }
}
