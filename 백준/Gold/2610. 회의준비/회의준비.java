import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] parent;
    static int[][] dist;
    static Map<Integer, List<Integer>> map;
    static int over = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        parent = new int[n+1];

        for (int i=1; i<=n; i++){
            parent[i] = i;
        }

        dist = new int[n+1][n+1];
        for (int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = 1;
            dist[b][a] = 1;
            union(a,b);
        }

        makeDistArr();
        makeGroupMap();
        System.out.println(map.size());

        map.keySet().stream()
                .mapToInt(Main::getMinDistCandidate)
                .sorted()
                .forEach(System.out::println);
    }

    public static void makeGroupMap(){
        map = new HashMap<>();
        for (int i=1; i<=n; i++){
            int key = find(i);
            List<Integer> current = map.getOrDefault(key, new ArrayList<>());
            current.add(i);
            map.put(key, current);
        }
    }

    public static int getMinDistCandidate(int groupKey){
        int minDist = over;
        int minCandidate=-1;
        for (int k: map.get(groupKey)){
            int curMax = 0;
            for (int l:map.get(groupKey)){
                curMax = Math.max(curMax, dist[k][l]);
            }

            if(curMax<=minDist){
                minDist = curMax;
                minCandidate = k;
            }
        }

        return minCandidate;
    }

    public static int find(int v){
        if(v==parent[v]){
            return v;
        }
        
        return parent[v]=find(parent[v]);
    }

    public static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);

        if(pa<pb) {
            parent[pb] = pa;
        } else{
            parent[pa] = pb;
        }
    }

    public static void makeDistArr(){
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if(i!=j && dist[i][j]==0){
                    dist[i][j] = over;
                }
            }
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
    }
}