import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[] input;
    static StringBuilder sb;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        input = new int[N];
        arr = new int[M];

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
        if (k == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int temp = -1; // 해당 재귀에서 마지막에 사용해본 숫자
        for (int i = 0; i < N; i++) {
            if (temp != input[i]) { // 마지막에 사용해본 숫자를 또 사용하면 중복 수열이 되므로 pass
                arr[k] = input[i];
                temp = input[i];
                recursive(k + 1);
            }
        }
    }
}
