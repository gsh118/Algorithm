import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int m1=Math.min(h-y, y);
        int m2=Math.min(w-x, x);

        bw.write(Math.min(m1,m2)+"");
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}