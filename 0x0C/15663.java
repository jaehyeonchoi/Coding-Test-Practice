import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] used;
    static int[] input;
    static StringBuilder sb;
    static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        used = new boolean[N];
        input = new int[N];
        set = new HashSet<>();

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
            StringBuilder tempSb = new StringBuilder();
            for (int i : arr) {
                tempSb.append(input[i]).append(" ");
            }
            tempSb.append("\n");

            String tempStr = tempSb.toString();
            if (!set.contains(tempStr)) { // 중복되는 수열인지 확인
                set.add(tempStr);
                sb.append(tempStr);
            }
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
