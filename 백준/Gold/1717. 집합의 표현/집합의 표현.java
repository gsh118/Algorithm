import java.io.*;
import java.util.*;

class Main{
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for (int i=0; i<n+1; i++){
            parent[i] = i;
        }

        Main t = new Main();

        for (int i=0; i<m; i++){
            int[] arr = new int[3];
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<3; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            if(arr[0]==0){
                t.union(arr[1],arr[2]);
            } else{
                String result = t.isSameSet(arr[1],arr[2])? "YES" : "NO";
                bw.write(result+"\n");
            }
        }

        br.close();
        bw.close();
    }

    public void union(int a, int b){
        if(!isSameSet(a,b)){
            int pa=find(a);
            int pb=find(b);

            if(pa<pb){
                parent[pb]=parent[pa];
            } else{
                parent[pa]=parent[pb];
            }
        }
    }

    public boolean isSameSet(int a, int b){
        return find(a)==find(b);
    }

    public int find(int a){
        int tmp = a;
        while (parent[tmp]!=tmp){
            tmp=parent[tmp];
        }
        return parent[a]=tmp;
    }
}