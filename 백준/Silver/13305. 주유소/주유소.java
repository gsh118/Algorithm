import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static long solution(int n, int[] roads, int[] prices){

        long cost=0;

        int cur=0;
        while(cur<n-1) {
            int j=cur+1;
            while(j<n-1 && prices[cur]<prices[j]) {
                cost+= (long) roads[j - 1] *prices[cur];
                j++;
            }
            cost+= (long) roads[j - 1] *prices[cur];
            cur=j;
        }
        return cost;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] roads = new int[n-1];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n-1; i++){
            roads[i] = Integer.parseInt(st.nextToken());
        }

        int[] prices = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            prices[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, roads, prices));
    }
}