import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 0 ~ 가장 높은 나무의 높이 사이에서 절단기에 설정할 수 있는 높이의 최댓값을 찾기
        int start = 0;
        int end = arr[N - 1];
        int ans = 0; // 절단기에 설정할 수 있는 높이의 최댓값
        while (start <= end) {
            int mid = (start + end) / 2;
            if (check(mid)) { // mid 높이로 잘랐을 때, M미터 이상의 나무를 가져갈 수 있는 경우
                ans = mid; // 최댓값 갱신
                start = mid + 1; // mid보다 큰 범위에서 다시 탐색
            }
            else { // mid 높이로 잘랐을 때, M미터 이상의 나무를 가져갈 수 없는 경우
                end = mid - 1; // mid보다 작은 범위에서 다시 탐색
            }
        }
        System.out.println(ans);
    }

    public static boolean check(int x) { // 높이 x로 잘랐을 때, M미터 이상의 나무를 가져갈 수 있는지
        long sum = 0;
        for (int tree : arr) {
            sum += Math.max(0, tree - x);
        }
        return sum >= M;
    }
}
