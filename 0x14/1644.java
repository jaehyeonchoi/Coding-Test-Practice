import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1]; // 합이 N이 되어야 하므로, N 이하의 소수들만 찾으면 됨

        arr[0] = true;
        arr[1] = true;
        for (int n = 2; n < N + 1; n++) { // 에라토스테네스의 채 방식으로 소수 찾기
            if (!arr[n]) {
                int nn = n + n;
                while (nn < N + 1) {
                    arr[nn] = true;
                    nn += n;
                }
            }
        }

        ArrayList<Integer> prime = new ArrayList<>(); // N 이하 소수들을 리스트에 저장
        for (int i = 0; i < N + 1; i++) {
            if(!arr[i]) {
                prime.add(i);
            }
        }

        int count = 0; // 가능한 연속된 소수합의 개수
        int start = 0; // 연속된 소수의 시작 인덱스
        int end = 0; // 연속된 소수의 끝 인덱스

        while (end < prime.size() && start <= end) {
            int sum = 0; // 연속된 소수의 합
            for (int i = start; i <= end; i++) {
                sum += prime.get(i);
            }

            if (sum < N) { // 합이 N보다 작은 경우
                end++; // 끝 인덱스를 늘리기 -> 합을 늘리기
            }
            if (sum > N) { // 합이 N보다 큰 경우
                start++; // 시작 인덱스를 늘리기 -> 합을 줄이기
            }
            if (sum == N) { // 합이 N과 같은 경우
                count++; // 소수합의 개수
                end++; // 끝 인덱스를 늘리기 -> 새로운 조합 찾기
            }
        }
        System.out.println(count);
    }
}
