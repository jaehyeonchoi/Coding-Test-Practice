import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int sum2 = 0; // 팩토리얼에 들어있는 2의 거듭제곱 지수
        int sum5 = 0; // 팩토리얼에 들어있는 5의 거듭제곱 지수
        for (int i = 2; i <= N; i++) { // 2 ~ N까지 각각 2, 5가 몇 개씩 곱해져 있는지 계산
            int exp2 = 1;
            int exp5 = 1;
            while (i % Math.pow(2, exp2) == 0) {
                exp2++;
            }
            while (i % Math.pow(5, exp5) == 0) {
                exp5++;
            }
            sum2 += exp2 - 1;
            sum5 += exp5 - 1;
        }
        System.out.println(Math.min(sum2, sum5)); // 2의 지수, 5의 지수 중 최솟값이 10의 지수가 됨
    }
}
