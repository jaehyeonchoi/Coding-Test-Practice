import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        LinkedList<Character> charList = new LinkedList<>();
        for (int i = 0; i< str.length(); i++) {
            charList.add(str.charAt(i));
        }

        ListIterator<Character> cursor = charList.listIterator(charList.size());

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            switch (command) {
                case "L":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                    }
                    break;
                case "D":
                    if (cursor.hasNext()) {
                        cursor.next();
                    }
                    break;
                case "B":
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                default:
                    char c = command.charAt(2);
                    cursor.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : charList) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
