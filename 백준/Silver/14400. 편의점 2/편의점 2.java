import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().split(" ")[0]);

        long [] xCoords = new long [n];
        long [] yCoords = new long [n];

        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            xCoords[i] = Long.parseLong(st.nextToken());
            yCoords[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(xCoords);
        Arrays.sort(yCoords);

        long xMed = xCoords[n/2];
        long yMed = yCoords[n/2];

        long xDist = Arrays.stream(xCoords).map(x->Math.abs(x-xMed)).sum();
        long yDist = Arrays.stream(yCoords).map(y->Math.abs(y-yMed)).sum();

        bw.write(xDist+yDist+"");
        bw.close();
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}