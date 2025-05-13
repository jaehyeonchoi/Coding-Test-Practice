import java.io.*;

public class Main {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        int count5 = 0; // 무조건 5보다 2가 많으므로 5의 개수만 세도 됨
        while (N >= 5) {
            count5 += N / 5;
            N /= 5;
        }
        System.out.println(count5);
    }
}
