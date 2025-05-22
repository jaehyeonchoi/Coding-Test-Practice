import java.io.*;
import java.util.*;

public class Main {
    static int M, N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 0 ~ 가장 긴 과자 길이 사이에서 정답을 이분탐색으로 찾기
        int start = 0;
        int end = arr[N - 1];
        int ans = 0; // 만들 수 있는 최대 과자 길이
        while (start <= end) {
            int mid = (start + end) / 2;
            if (func(mid)) { // mid만큼의 길이로 사람 수 이상의 과자를 만들 수 있는 경우
                ans = mid; // 가능한 최대 과자 길이 갱신
                start = mid + 1; // start를 mid보다 큰 범위로 옮김
            }
            else { // mid만큼의 길이로 사람 수 이상의 과자를 만들 수 없는 경우
                end = mid - 1; // end를 mid보다 작은 범위로 옮김
            }
        }
        System.out.println(ans);
    }
    private static boolean func(int x) { // mid만큼의 길이로 사람 수(M) 이상의 과자를 만들 수 있는지 확인
        if (x == 0) { // 0이면 무조건 가능
            return true;
        }
        int count = 0; // 총 과자 개수
        for (int snack : arr) {
            count += snack / x;
        }
        return count >= M;
    }
}
