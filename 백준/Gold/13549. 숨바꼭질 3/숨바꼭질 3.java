import java.util.*;

public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new int[100001];
        Arrays.fill(dp, 1000000);

        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComp());
        pq.add(new Node(n, 0));
        while(!pq.isEmpty()){
            Node cur = pq.remove();

            if(cur.dist<dp[cur.pos]){
                dp[cur.pos]=cur.dist;

                int[] delta={-1,1};
                for (int i=0; i<delta.length; i++){
                    int nx = cur.pos+delta[i];
                    if(nx<0 || nx>100000){
                        continue;
                    }
                    if(cur.dist+1<dp[nx]){
                        pq.add(new Node(nx, cur.dist+1));
                    }
                }

                if (2*cur.pos<=100000 && cur.dist<dp[2*cur.pos]){
                    pq.add(new Node(cur.pos*2, cur.dist));
                }
            }
        }
        System.out.println(dp[k]);
    }
}

class Node{
    int pos;
    int dist;
    public Node(int pos, int dist) {
        this.pos = pos;
        this.dist = dist;
    }
}

class NodeComp implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2){
        if(o1.dist!= o2.dist){
            return o1.dist-o2.dist;
        }
        return o1.pos-o2.pos;
    }
}