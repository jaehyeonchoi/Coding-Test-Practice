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

        int start = 0; // 연속된 소수의 시작 인덱스
        int end = 0; // 연속된 소수의 끝 인덱스
        int sum = 0; // 연속된 소수의 합
        int count = 0; // 가능한 연속된 소수합의 개수

        while (start <= end) {
            if (sum > N) { // 합이 N보다 큰 경우
                sum -= prime.get(start++); // 가장 앞에 있던 숫자를 빼기
            }
            else { // 합이 N과 같거나 작은 경우
                if (sum == N) { // 합이 N과 같으면
                    count++; // 소수합의 개수 + 1
                }
                if (end == prime.size()) { // end를 늘려야하는데 이미 끝에 도달한 경우
                    break; // 탐색종료
                }
                sum += prime.get(end++); // 가장 뒤에 새로운 숫자를 더하기
            }
        }
        System.out.println(count);
    }
}
