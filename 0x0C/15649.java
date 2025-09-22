import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] arr;

    private static boolean[] used;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        used = new boolean[N];

        func(0);
    }

    public static void func(int k) {

        // 길이 M 짜리 수열을 완성하고 나면 출력 후 리턴 -> 재귀 종료
        if (k == M) { 
            StringBuilder sb = new StringBuilder(); // print로 각각 출력하는 것보다 StringBuilder로 String을 먼저 만든 후 출력하는 것이 더 빠름
            for (int x : arr) {
                sb.append(x + 1).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!used[i]) {
                arr[k] = i;
                used[i] = true; // 재귀적으로 호출된 곳에서 다시 사용하지 않도록 used를 true로 표시
                func(k + 1);
                used[i] = false; // 메서드 결과가 리턴된 후에는 다시 사용할 수 있도록 used 값을 false로 돌려놓기
            }
        }
    }
}
