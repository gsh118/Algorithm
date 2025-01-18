import java.util.*;
import java.io.*;

class Main{

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        boolean[] set = new boolean[21];
        int m = Integer.parseInt(br.readLine());

        for (int i=0; i<m; i++){
            parseCommand(set, br.readLine());
        }

        br.close();
        bw.close();

    }

    public static void parseCommand(boolean[] set, String commandStr) throws IOException {

        StringTokenizer st = new StringTokenizer(commandStr);
        String command = st.nextToken();

        Integer x = null;
        if (!commandStr.equals(command)){
            x = Integer.parseInt(st.nextToken());
        }

        switch(command) {
            case "add":
                set[x]=true;break;
            case "remove":
                set[x]=false;break;
            case "toggle":
                set[x]=!set[x];break;
            case "all":
                for (int i=1; i<=20; i++){
                    set[i]=true;
                }
                break;
            case "empty":
                for (int i=1; i<=20; i++){
                    set[i]=false;
                }
                break;
            default:
                bw.write(set[x]? "1\n":"0\n");
        }
    }
}