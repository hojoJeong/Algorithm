import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배배송_5972 {
    static int N, M;
    static ArrayList<ArrayList<Node>> list;
    static int[] dist;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new int[N];
        vis = new boolean[N];

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());

            list.get(start).add(new Node(end, value));
            list.get(end).add(new Node(start, value));
        }

        int ans = getResult(0, N - 1);

        System.out.println(ans);
    }

    static int getResult(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(vis, false);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int curNum = cur.num;

            if (!vis[curNum]) {
                vis[curNum] = true;
                for (Node nextNode : list.get(curNum)) {
                    if (dist[nextNode.num] > dist[curNum] + nextNode.value) {
                        dist[nextNode.num] = dist[curNum] + nextNode.value;
                        pq.add(new Node(nextNode.num, dist[nextNode.num]));
                    }
                }
            }
        }

        return dist[end];
    }

    static class Node {
        int num, value;

        public Node(int num, int value) {
            this.num = num;
            this.value = value;
        }
    }
}
