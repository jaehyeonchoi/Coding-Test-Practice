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
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        int temp = -1; // 마지막에 사용해봤던 숫자
        for (int i = 0; i < N; i++) {
            if (!used[i] && temp != input[i]) { 
                // 마지막에 사용해봤던 숫자와 새로 사용해보려는 숫자가 같으면 중복되는 수열이 만들어지므로 pass
                temp = input[i];
                arr[k] = temp;
                used[i] = true;
                recursive(k + 1);
                used[i] = false;
            }
        }
    }
}
