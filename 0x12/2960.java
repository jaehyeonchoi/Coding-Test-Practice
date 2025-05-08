import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new boolean[N + 1];

        int count = 0;
        for (int i = 2; i <= N; i++) {
            if (!arr[i]) { // 아직 지우지 않은 수 중에서 가장 작은 수 찾기
                int curr = i; // 현재 지우려고 하는 수 (x의 배수)
                while (curr <= N) {
                    if (!arr[curr]) { // 아직 안 지워진 경우
                        arr[curr] = true; // 지우기
                        if (++count == K) { // K번째 지워진 수인 경우
                            System.out.println(curr); // 출력 후 종료
                            return;
                        }
                    }
                    curr += i;
                }
            }
        }
    }
}
