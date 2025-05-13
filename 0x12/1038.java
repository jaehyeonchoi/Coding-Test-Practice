import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        for (long i = 0; i < 10; i++) {
            recursive(i);
        }
        Collections.sort(list);
        if (N >= list.size()) {
            System.out.println(-1);
            return;
        }
        System.out.println(list.get(N));
    }

    public static void recursive(Long num) {
        list.add(num);
        int last = (int) (num % 10);
        for (int i = 0; i < last; i++) {
            recursive(num * 10 + i);
        }
    }
}
