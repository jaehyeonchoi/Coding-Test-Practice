import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int n = 0; n < N; n++) {
            arr[n] = Integer.parseInt(st.nextToken());
        }

        long min = Long.MAX_VALUE; // 절댓값이 최소인 혼합 용액
        int a = -1; // 혼합할 용액 1
        int b = -1; // 혼합할 용액 2
        for (int i = 0; i < N; i++) { // 각 용액에 대해서, 부호가 반대인 값에 가장 가까운 용액을 찾기
            int start = i + 1;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                int newValue = Math.abs(arr[i] + arr[mid]);
                if (min > newValue) { // 절댓값이 더 작은 혼합 용액이면 갱신
                    min = newValue;
                    a = arr[i];
                    b = arr[mid];
                }
                if (arr[mid] == -arr[i]) {
                    break;
                }
                if (arr[mid] > -arr[i]) {
                    end = mid - 1;
                }
                if (arr[mid] < -arr[i]) {
                    start = mid + 1;
                }
            }
        }
        System.out.println(a + " " + b);
    }
}
