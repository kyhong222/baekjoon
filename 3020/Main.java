import java.util.Arrays;

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

        int[] top = new int[N / 2];
        int[] bottom = new int[N / 2];

        int t = 0, b = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                bottom[b] = Ns[i];
                b++;
            } else {
                top[t] = Ns[i];
                t++;
            }
        }

        Arrays.sort(top);
        Arrays.sort(bottom);

        // System.out.print("top");
        // System.out.println(Arrays.toString(top));
        // System.out.print("bottom");
        // System.out.println(Arrays.toString(bottom));

        int h = top[0] - 1;
        solutionArray[h] = 1;
        for (int i = 1; i < top.length; i++) {
            if (top[i] > top[i - 1]) {
                h += top[i] - top[i - 1];
            }
            solutionArray[h]++;
        }

        int h2 = bottom[0] - 1;
        int[] solutionArray2 = new int[H];
        solutionArray2[h2] = 1;
        for (int i = 1; i < bottom.length; i++) {
            if (bottom[i] > bottom[i - 1]) {
                h2 += bottom[i] - bottom[i - 1];
            }
            solutionArray2[h2]++;
        }

        // System.out.print("solution");
        // System.out.println(Arrays.toString(solutionArray));
        // System.out.print("solution2");
        // System.out.println(Arrays.toString(solutionArray2));

        for (int i = H - 2; i >= 0; i--) {
            solutionArray[i] += solutionArray[i + 1];
            solutionArray2[i] += solutionArray2[i + 1];
        }
        // solutionArray[3] += solutionArray[4];
        // solutionArray[2] += solutionArray[3];
        // solutionArray[1] += solutionArray[2];
        // solutionArray[0] += solutionArray[1];

        // solutionArray2[3] += solutionArray2[4];
        // solutionArray2[2] += solutionArray2[3];
        // solutionArray2[1] += solutionArray2[2];
        // solutionArray2[0] += solutionArray2[1];

        // System.out.print("solution");
        // System.out.println(Arrays.toString(solutionArray));
        // System.out.print("solution2");
        // System.out.println(Arrays.toString(solutionArray2));

        for (int i = 0; i < H; i++) {
            solutionArray2[i] += solutionArray[H - 1 - i];
        }
        // System.out.print("solution2");
        // System.out.println(Arrays.toString(solutionArray2));
        int min = solutionArray2[0];
        int count = 1;
        for (int i = 1; i < solutionArray2.length; i++) {
            if (min > solutionArray2[i]) {
                count = 1;
                min = solutionArray2[i];
            } else if (min == solutionArray2[i]) {
                count++;
            } else {
                continue;
            }
        }
        System.out.print(min);
        System.out.print(" ");
        System.out.print(count);
    }
}