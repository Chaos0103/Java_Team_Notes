import java.util.*;

class Edge implements Comparable<Edge> {

    private int index; //정점
    private int cost; //가중치

    public Edge(int weight, int cost) {
        this.index = weight;
        this.cost = cost;
    }

    public int getIndex() {
        return index;
    }

    public int getCost() {
        return cost;
    }

    //오름차순으로 정렬
    @Override
    public int compareTo(Edge o) {
        if (this.cost < o.cost) {
            return -1;
        }
        return 1;
    }
}

public class Main {

    private static int v, e;
    private static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();

    //프림 알고리즘
    private static int prim(int start) {
        //방문여부를 찍기 위한 visited 배열
        boolean[] visited = new boolean[v + 1];

        //알고리즘의 성능을 위해 우선순위 큐를 사용하여 시간복잡도 줄임
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        //첫번째 노드는 이동 한 적이 없으므로 가중치는 0
        pq.offer(new Edge(start, 0));

        int total = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int index = edge.getIndex();
            int cost = edge.getCost();
            //이미 방문한 적이 있는 노드라면 건너뛰기
            if (visited[index]) {
                continue;
            }
            //방문 처리
            visited[index] = true;
            //가중치 증가
            total += cost;

            //현재와 연결된 모든 노드들을 확인
            for (int i = 0; i < graph.get(index).size(); i++) {
                //방문한 적이 없는 노드라면 우선순위큐에 삽입
                if (!visited[graph.get(index).get(i).getIndex()]) {
                    pq.add(graph.get(index).get(i));
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        v = sc.nextInt();
        e = sc.nextInt();

        //그래프 초기화
        for (int i = 0; i <= v; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            //양방향 설정
            graph.get(a).add(new Edge(b, cost));
            graph.get(b).add(new Edge(a, cost));
        }

        //프림 알고리즘 수행
        int result = prim(1);
        System.out.println(result);
    }
}
