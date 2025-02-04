import java.util.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        String a=st.nextToken();
        String b=st.nextToken();

        Main t = new Main();
        System.out.println(t.getMinDist(a,b));
    }

    public int getMinDist(String a, String b){
        int diffLength=b.length()-a.length();
        int dist=0;
        for (int i=0; i<=diffLength; i++){
            int curDist=0;
            for (int j=0; j<a.length(); j++){
                if(a.charAt(j)==b.charAt(i+j)){
                    curDist++;
                }
            }
            dist=Math.max(dist, curDist);
        }
        
        return a.length()-dist;
    }
}