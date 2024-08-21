import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int t= Integer.parseInt(st.nextToken());

        while ((t--)>0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            int [][] arr = new int[n][2];

            for (int i=0; i<n; i++){

                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());

            }

            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0]-o2[0];
                }
            });

            int cnt=1;
            int cutLine=arr[0][1];
            for (int i=1; i<n; i++){
                if (arr[i][1]<cutLine){
                    cnt++;
                    cutLine=arr[i][1];
                }
            }
            bw.write(cnt+"\n");
        }

        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}