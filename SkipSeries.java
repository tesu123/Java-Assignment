
import java.util.Scanner;

public class SkipSeries {
    public static void main(String[] args) {
        int n, skip, skip_cnt, prev_len, curr_len;
        int[] arr;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        n = sc.nextInt();

        arr = new int[n];

        System.out.println();
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
            System.out.print(arr[i] + " ");
        }

        skip = 2;
        skip_cnt = 2;
        prev_len = n;

        while (true) {
            System.out.println();

            curr_len = 0;
            for (int i = 0; i < n && prev_len >= skip_cnt; i = i + skip) {
                System.out.print(arr[i] + " ");
                curr_len = curr_len + 1;
            }

            if (skip >= n)
                break;

            prev_len = curr_len;
            skip_cnt = skip_cnt + 1;
            skip = skip * skip_cnt;
        }

        sc.close();
    }
}