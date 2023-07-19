import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 암호문3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        LinkedList<Integer> list;
        for (int tc = 1; tc <= 10; tc++) {
            list = new LinkedList<>();

            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                char option = st.nextToken().charAt(0);

                switch (option) {
                    case 'I': {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        for (int i = x; i < x + y; i++) {
                            int code = Integer.parseInt(st.nextToken());
                            list.add(i, code);
                        }
                        break;
                    }
                    case 'D': {
                        int x = Integer.parseInt(st.nextToken());
                        int y = Integer.parseInt(st.nextToken());
                        for (int i = x; i < x + y; i++) {
                            list.remove(i);
                        }
                        break;
                    }
                    case 'A': {
                        int y = Integer.parseInt(st.nextToken());
                        for (int i = 0; i < y; i++) {
                            int code = Integer.parseInt(st.nextToken());
                            list.add(code);
                        }
                        break;
                    }
                }
            }
            System.out.printf("#%d ", tc);
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d ", list.get(i));
            }
            System.out.println();
        }
    }
}
