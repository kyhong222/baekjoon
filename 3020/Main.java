import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // init
        // Scanner sc = new Scanner(System.in);

        // int N = sc.nextInt();
        // int H = sc.nextInt();

        // int[] Ns = new int[N];
        // for (int i = 0; i < N; i++) {
        // Ns[i] = sc.nextInt();
        // }

        // sc.close();

        // init example
        int N = 14;
        int H = 5;
        int[] Ns = new int[] { 1, 3, 4, 2, 2, 4, 3, 4, 3, 3, 3, 2, 3, 3 };

        // solution
        int[] solutionArray = new int[H];
        solutionArray[0] = N / 2;
        solutionArray[H - 1] = N / 2;
        int[] top = new int[H / 2];
        int[] bottom = new int[H / 2];
        int t = 0, b = 0;
        for (int i = 0; i < H; i++) {
            if (i % 2 == 0) {
                bottom[b] = Ns[i];
                b++;
            } else {
                top[t] = Ns[i];
                t++;
            }
        }

        Arrays.sort(top);

    }
}