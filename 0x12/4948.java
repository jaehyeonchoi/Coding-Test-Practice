import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<Integer> list;
    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList<>();

        int max = 0;
        while (true) { // 0이 입력될 때까지 n들의 값을 입력 받기
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }
            list.add(n);
            max = Math.max(max, n);
        }

        int size = max * 2 + 1;
        arr = new boolean[size]; // n들의 최댓값의 2배까지 처리할 수 있도록 배열 생성
        for (int i = 2; i < size; i++) { // 에라토스테네스의 체 알고리즘으로 소수만 false로 남기기
            if (!arr[i]) {
                int curr = i * 2;
                while (curr < size) {
                    if (!arr[curr]) {
                        arr[curr] = true;
                    }
                    curr += i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            int count = 0;
            for (int i = n + 1; i <= n * 2; i++) { // n + 1부터 2n까지의 소수 개수 세기
                if (!arr[i]) {
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
