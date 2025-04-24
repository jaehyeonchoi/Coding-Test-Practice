import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[] arr; // Comparator가 원시 자료형만 지원함

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr, Comparator.reverseOrder()); // 로프를 최대 중량 높은 순으로 정렬

        int max = 0; // 로프들로 들 수 있는 최대 중량
        for (int i = 0; i < N; i++) {
            // 새로운 로프를 추가하면, 해당 로프의 최대 중량 * 로프 개수만큼 들 수 있음
            max = Math.max(max, arr[i] * (i + 1));
        }
        System.out.println(max);
    }
}
