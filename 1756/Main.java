import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // init
        Scanner sc = new Scanner(System.in);

        int D = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[D];
        int[] arr2 = new int[N];

        for (int i = 0; i < D; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        // int D = 7;
        // int N = 3;

        // int[] arr = new int[] { 5, 6, 4, 3, 6, 2, 3 };
        // int[] arr2 = new int[] { 3, 2, 5 };
        // int[] arr4 = new int[] { 5, 5, 4, 3, 3, 2, 2 };
        int deep = 0;

        // solution
        int[] arr3 = new int[D];
        arr3[0] = arr[0];
        for (int i = 1; i < D; i++) {
            arr3[i] = arr3[i - 1];
            if (arr3[i] > arr[i]) {
                arr3[i] = arr[i];
            }
        }

        int count = 0;
        // System.out.println(Arrays.toString(arr3));
        // System.out.println(Arrays.toString(arr4));
        for (int i = D - 1; i >= 0; i--) {
            // System.out.print("count: ");
            // System.out.println(count);
            // System.out.print("i: ");
            // System.out.println(i);

            if (count == N) {
                break;
            }
            if (arr2[count] <= arr3[i]) {
                count++;
                deep = i;
                continue;
            }
        }

        if (deep != 0) {
            deep += 1;
        }

        System.out.println(deep);

    }
}