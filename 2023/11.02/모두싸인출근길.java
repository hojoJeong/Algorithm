import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 모두싸인출근길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        ArrayList<Panel> list = new ArrayList<>();
        ArrayList<Panel> panel = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.add(new Panel(start, end));
        }
        Collections.sort(list);

        int start = list.get(0).start;
        int end = list.get(0).end;

        for (int i = 1; i < N; i++) {
            if (end < list.get(i).start) {
                panel.add(new Panel(start, end));
                start = list.get(i).start;
                end = list.get(i).end;
            } else {    //판자가 겹쳐있는 경우
                end = Math.max(end, list.get(i).end);
            }
        }
        panel.add(new Panel(start, end));

        int dist = 0;   //판자 유무와 상관 없이 갈 수 있는 거리
        int position = 0;   //실제로 도착할 수 있는 지점
        for (int i = 0; i < panel.size(); i++) {
            if (dist >= panel.get(i).start) {
                position = panel.get(i).end;
                dist = Math.max(dist, position + panel.get(i).end - panel.get(i).start);
            }
        }

        System.out.println(position);
    }

    static class Panel implements Comparable<Panel> {
        int start, end;

        public Panel(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Panel p) {
            if (this.start != p.start) {
                return this.start - p.start;
            } else {
                return this.end - p.end;
            }
        }
    }
}
