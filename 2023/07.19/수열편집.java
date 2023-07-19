import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 수열편집 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                char option = st.nextToken().charAt(0);
                int index = Integer.parseInt(st.nextToken());

                switch (option){
                    case 'I' : {
                        int value = Integer.parseInt(st.nextToken());
                        list.add(index, value);
                        break;
                    }
                    case 'D' : {
                        list.remove(index);
                        break;
                    }
                    case 'C' : {
                        int value = Integer.parseInt(st.nextToken());
                        list.set(index, value);
                        break;
                    }
                }
            }

            int ans = list.size() <= l ? -1 : list.get(l);
            System.out.printf("#%d %d\n", tc, ans);
        }

    }
}
