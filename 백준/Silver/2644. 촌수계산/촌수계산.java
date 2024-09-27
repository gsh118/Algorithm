import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int num1, int num2, int m, int[][] arr){
        Queue<Integer> qu = new LinkedList<>();
        int[] dist = new int[n+1];

        ArrayList<Integer>[] neighbor = new ArrayList[n+1];

        for (int i=1; i<=n; i++) {
            neighbor[i]=new ArrayList<>();
            dist[i]=-1;
        }

        for (int i=0; i<m; i++) {
            neighbor[arr[i][0]].add(arr[i][1]);
            neighbor[arr[i][1]].add(arr[i][0]);
        }

        qu.add(num1);
        dist[num1]=0;
        while(!qu.isEmpty()) {
            int cur = qu.poll();
            for (int nxt: neighbor[cur]) {
                if(dist[nxt]==-1 || dist[nxt]>dist[cur]+1){
                    dist[nxt]=dist[cur]+1;
                    qu.add(nxt);
                }
            }
        }

        return dist[num2];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[m][2];
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, num1, num2, m, arr));
    }
}