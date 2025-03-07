import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] ipt = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            ipt[i] = Integer.parseInt(st.nextToken());
        }

        int[] nge = getNGE(ipt);
        for (int e : nge) {
            bw.write(e + " ");
        }
        br.close();
        bw.close();
    }

    public static int[] getNGE(int[] ipt){
        int n = ipt.length;
        Deque<Node> dq = new LinkedList<>();

        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        for (int i=0; i<n; i++){
            while(!dq.isEmpty() && dq.peekLast().value<ipt[i]){
                Node cur = dq.removeLast();
                nge[cur.index] = ipt[i];
            }
            dq.addLast(new Node(i, ipt[i]));
        }

        return nge;
    }
}

class Node{
    int index;
    int value;

    public Node(int index, int value) {
        this.index = index;
        this.value = value;
    }
}