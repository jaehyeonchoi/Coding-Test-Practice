import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int max = input[1];
        int curr = input[1];
        for (int i = 2; i <= N; i++) {
            curr = Math.max(curr + input[i], input[i]); // 기존 값에 더하거나, 새로 시작해서 더 큰 값 찾기
            max = Math.max(max, curr); // 새로 만든 값이 최댓값보다 크면 갱신
        }
        System.out.println(max);
    }
}
