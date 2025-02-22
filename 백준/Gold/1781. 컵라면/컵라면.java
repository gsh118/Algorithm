import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>(new QueueComparator());

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new ProblemComparator());

        int ramen = 0;
        for (int i=0; i<n; i++){
            if(pq.size()<arr[i][0]){
                pq.add(arr[i]);
            } else{
                if (pq.peek()[1]<arr[i][1]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        while(!pq.isEmpty()){
            ramen += pq.remove()[1];
        }

        System.out.println(ramen);
    }
}

class ProblemComparator implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2){

        if (o1[0]!=o2[0]){
            return o1[0]-o2[0];
        }

        return o2[1]-o1[1];
    }
}

class QueueComparator implements Comparator<int[]>{
    public int compare(int[] o1, int[] o2){
        return o1[1]-o2[1];
    }
}