import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr; // 전체 수열
    static int[] d; // 증가하는 부분 수열의 최대 합

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        d = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = arr[1];
        int maxSum = d[1];
        for (int i = 2; i <= N; i++) { // i번째 숫자까지 봤을 때, 증가하는 부분 수열의 최대 합 구하기
            for (int j = i - 1; j >= 0; j--) { // 1 ~ (i - 1)번째 숫자까지 봤을 때의 최대 합 활용
                // (j = 0 -> i번째 숫자 앞에 더 작은 숫자가 하나도 없을 경우, i번째 숫자를 그대로 넣도록 함)
                if (arr[i] > arr[j]) { // i번째 숫자가 j번째 숫자보다 큰 경우
                    d[i] = Math.max(d[i], d[j] + arr[i]); // j번째 숫자에서 만들 수 있는 최대 합 + i번째 숫자로 최댓값 갱신
                }
            }
            maxSum = Math.max(maxSum, d[i]);
        }
        System.out.println(maxSum);
    }
}
