import java.io.*;

public class Main {
    static int X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        X = Integer.parseInt(br.readLine());

        int count = 1;
        while (true) {
            if (X > count) {
                X -= count++;
            }
            else {
                int bj;
                int bm;
                if (count % 2 == 0) { // 짝수
                    bj = X;
                    bm = count - X + 1;
                }
                else { // 홀수
                    bj = count - X + 1;
                    bm = X;
                }
                System.out.println(bj + "/" + bm);
                return;
            }
        }
    }
}
