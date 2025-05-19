import java.io.*;
import java.util.*;

public class Main {
    static int N, k;
    static int num; // k번째 숫자가 포함된 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int i = 1; // num의 자릿수
        while (k > i * 9 * Math.pow(10, i - 1)) { // k에서 1 * 9(한자리수 개수), 2 * 90(두자리수 개수)... 씩 빼기
            k -= (int)(i * 9 * Math.pow(10, i - 1)); // 더 이상 못 뺄 때가 num의 자릿수
            i++;
        }
        int a = (k - 1) / i; // num이 i자리 수 중 몇 번째인지(0번째부터 셈)
        int b = (k - 1) % i; // k번째 숫자가 num 기준 앞에서부터 몇 번째 숫자인지(0번째부터 셈)

        num = (int)(Math.pow(10, i - 1) + a); // num은 10^(i-1)부터 a번째 수
        if (num > N) { // num이 N보다 크면 k번째 숫자는 존재할 수 없음
            System.out.println(-1);
            return;
        }
        String str = Integer.toString(num);
        System.out.println(str.charAt(b)); // num의 b번째 숫자를 출력
    }
}
