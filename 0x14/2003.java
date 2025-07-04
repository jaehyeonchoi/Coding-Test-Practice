import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            A[n] = Integer.parseInt(st.nextToken());
        }

        int start = 0; // 연속범위 시작
        int end = 0; // 연속범위 끝
        long sum = 0; // 연속범위의 합
        long count = 0; // 연속범위의 합이 M이 되는 경우의 수

        while (start <= end) {
            if (sum > M) { // 연속범위의 합이 M보다 크면
                sum -= A[start++]; // 가장 앞의 숫자를 빼기
            }
            else { // 연속범위의 합이 M보다 작거나 같으면
                if (sum == M) { // 연속범위의 합이 M인 경우
                    count++; // 경우의 수 + 1
                }
                if (end == N) { // end를 늘려야하는데 이미 끝까지 도달한 경우
                    break; // 탐색종료
                }
                sum += A[end++]; // 가장 뒤에 새로운 숫자를 더하기
            }
        }
        System.out.println(count);
    }
}
