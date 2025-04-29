import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Integer> plusArr;
    static ArrayList<Integer> minusArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        plusArr = new ArrayList<>();
        minusArr = new ArrayList<>();
        int sum = 0;
        boolean zero = false;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) {
                plusArr.add(num);
            }
            if (num == 1) {
                sum++;
            }
            if (num == 0) {
                zero = true;
            }
            if (num < 0) {
                minusArr.add(num);
            }
        }
        Collections.sort(plusArr, Collections.reverseOrder());
        Collections.sort(minusArr);

        for (int i = 0; i < plusArr.size() / 2; i++) {
            sum += plusArr.get(i * 2)* plusArr.get(i * 2 + 1);
        }
        if (plusArr.size() % 2 != 0) {
            sum += plusArr.get(plusArr.size() - 1);
        }
        for (int i = 0; i < minusArr.size() / 2; i++) {
            sum += minusArr.get(i * 2)* minusArr.get(i * 2 + 1);
        }
        if (minusArr.size() % 2 != 0) {
            if (!zero) {
                sum += minusArr.get(minusArr.size() - 1);
            }
        }
        System.out.println(sum);
    }
}
