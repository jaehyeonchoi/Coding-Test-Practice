import java.io.*;
import java.util.*;

public class Main {
    static int T;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        int max = -1;
        for (int i = 0; i < T; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > max) {
                max = x;
            }
            list.add(x);
        }

        arr = new int[max + 1];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;


        for (int i = 4; i < max + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }

        for (int i : list) {
            System.out.println(arr[i]);
        }
    }
}
