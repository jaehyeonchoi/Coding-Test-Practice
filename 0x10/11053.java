import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] input; // 전체 수열
    static int[] d; // n번째 숫자까지 봤을 때, 만들 수 있는 증가하는 부분수열 최대 길이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N + 1];
        d = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        d[1] = 1;
        int maxLength = 1; // 증가하는 부분수열 최대 길이
        for (int i = 2; i <= N; i++) { // i번째 숫자까지 봤을 때, 만들 수 있는 증가하는 부분수열 최대 길이 찾기
            for (int j = i - 1; j >= 0; j--) { // 1 ~ (i - 1)번째 숫자에서의 최대 길이를 활용
                // (j = 0 -> i보다 작은 숫자가 앞에 없는 경우에 1 값이 들어가도록 함)
                if (input[i] > input[j]) { // i번째 숫자가 j번째 숫자보다 큰 경우
                    d[i] = Math.max(d[i], d[j] + 1); // j번째 숫자에서 만들 수 있는 최대 길이 + 1해서 최댓값 갱신
                }
            }
            maxLength = Math.max(maxLength, d[i]);
        }
        System.out.println(maxLength);
    }
}
