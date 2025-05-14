
import java.util.Scanner;

class SkipElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the range: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        int size = n;

        // Fill array with 1 to n
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        int skipDist = 2;

        while (skipDist <= size) {
            // Print current array
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            // Create new array with every skipDist-th element
            int newSize = (size + skipDist - 1) / skipDist; // ceil(size / skipDist)
            int[] temp = new int[newSize];
            int idx = 0;

            for (int i = 0; i < size; i += skipDist) {
                temp[idx++] = arr[i];
            }

            // Update for next iteration
            arr = temp;
            size = newSize;
            skipDist++;
        }

        // Print final array
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\nCompleted.");

        sc.close();
    }
}
