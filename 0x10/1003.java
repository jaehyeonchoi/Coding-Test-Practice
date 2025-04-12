import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] arr0;
    static int[] arr1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int max = 1;
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > max) {
                max = x;
            }
            list.add(x);
        }

        arr0 = new int[max + 1];
        arr0[0] = 1;
        arr0[1] = 0;

        arr1 = new int[max + 1];
        arr1[0] = 0;
        arr1[1] = 1;

        for (int i = 2; i < max + 1; i++) {
            arr0[i] = arr0[i - 1] + arr0[i - 2];
            arr1[i] = arr1[i - 1] + arr1[i - 2];
        }

        for (int i : list) {
            System.out.println(arr0[i] + " " + arr1[i]);
        }
    }
}
