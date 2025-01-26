import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] inputVertices = new int[2047][11];

        for (int i=0; i<2047; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<11; j++){
                inputVertices[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();

        int[] lostVertex = findLostVertexByXor(inputVertices);
        for (var v: lostVertex){
            bw.write(v+" ");
        }
        bw.close();
    }

// 1개만 모를땐 나머지를 xor해서 찾을 수 있음
    public static int[] findLostVertexByXor(int[][] inputVertices){
        int[] coords = new int[11];

        for (int i=0; i<2047; i++){
            for (int j=0; j<11; j++){
                coords[j]^=inputVertices[i][j];
            }
        }

        return coords;
    }
}