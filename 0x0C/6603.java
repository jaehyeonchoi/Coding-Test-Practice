import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] arr;
    static int[] input;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        arr = new int[6];

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) {
                break;
            }

            input = new int[k];
            for (int i = 0; i < k; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            recursive(0, -1);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int t, int last) {
        if (t == 6) {
            for (int i = 0; i < t; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = last + 1; i < k; i++) {
            arr[t] = input[i];
            recursive(t + 1, i);
        }
    }
}
