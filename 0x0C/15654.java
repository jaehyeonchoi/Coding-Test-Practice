import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static int[] input;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        used = new boolean[N];
        input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        sb = new StringBuilder();
        recursive(0);
        System.out.println(sb);
    }

    public static void recursive(int k) {
        if (k == M) { // M개의 숫자를 모두 선택한 경우
            for (int i : arr) {
                sb.append(input[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                arr[k] = i;
                used[i] = true;
                recursive(k + 1);
                used[i] = false;
            }
        }
    }
}
