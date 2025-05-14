import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        List<Integer>[] up = (List<Integer>[]) new ArrayList<?>[n+1];
        List<Integer>[] down = (List<Integer>[]) new ArrayList<?>[n+1];

        for (int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(down[a]==null){
                down[a] = new ArrayList<>();
            }
            if(up[b]==null){
                up[b] = new ArrayList<>();
            }

            down[a].add(b);
            up[b].add(a);
        }
        br.close();

        boolean[] visited = new boolean[n+1];
        int badRank = n+1-countNeighbor(x, down, visited);
        visited = new boolean[n+1];
        int goodRank = countNeighbor(x, up, visited);

        System.out.println(goodRank + " " + badRank);
    }

    static int countNeighbor(int start, List<Integer>[] neighbor, boolean[] visited){
        if(visited[start]){
            return 0;
        }

        visited[start]=true;

        if(neighbor[start]==null){
            return 1;
        }

        return 1+neighbor[start].stream()
                .mapToInt(a->countNeighbor(a, neighbor, visited))
                .sum();
    }
}