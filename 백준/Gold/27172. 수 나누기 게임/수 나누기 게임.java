import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[n];

        int max_num=0;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<n; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            max_num = Math.max(max_num, cards[i]);
        }

        int[] multiply_list = new int[max_num+1];
        boolean[] check_list = new boolean[max_num+1];

        for (int i=0; i<n; i++){
            check_list[cards[i]] = true;
        }

        for (int i=0; i<n; i++){
            for (int j=2; cards[i]*j<=max_num; j++){
                if (check_list[cards[i]*j]) {
                    multiply_list[cards[i]*j]--;
                    multiply_list[cards[i]]++;
                }
            }
        }

        for (int i=0; i<n; i++){
            bw.write(multiply_list[cards[i]]+" ");
        }

        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}