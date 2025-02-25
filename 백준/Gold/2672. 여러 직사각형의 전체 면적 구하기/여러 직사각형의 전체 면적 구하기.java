import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args)  throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        SquareBoard sb = new SquareBoard();
        for (int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int[] ipt = new int[4];

            for (int j=0; j<4; j++){
                ipt[j] = (int) (Float.parseFloat(st.nextToken())*10);
            }

            sb.addSquare(ipt[0],ipt[1],ipt[2],ipt[3]);
        }

        int area = sb.getArea();
        if(area%100==0){
            System.out.println(area/100);
        } else{
            System.out.printf("%.2f",area/100.0);
        }
    }
}

class Line implements Comparable<Line>{
    public int start;
    public int end;

    public Line(int start, int end){
        this.start=start;
        this.end=end;
    }

    public boolean canAttach(Line other){
        return this.end>=other.start;
    }

    public int compareTo(Line other){
        if(this.start!=other.start){
            return this.start-other.start;
        }

        return this.end-other.end;
    }
}

class SquareBoard{
    List<Line> [] squares;

    public SquareBoard(){
        squares = new ArrayList[20000];
        for (int i = 0; i < squares.length; i++) {
            squares[i] = new ArrayList<>();
        }
    }

    public int getArea(){
        int area=0;
        for (int i=0; i<20000; i++){
            area+=getLineArea(i);
        }

        return area;
    }

    private int getLineArea(int y) {
        List<Line> curLines = squares[y];
        if (curLines.isEmpty()) return 0;

        Collections.sort(curLines);
        int area = 0;
        int currentStart = curLines.get(0).start;
        int currentEnd = curLines.get(0).end;

        for (int i = 1; i < curLines.size(); i++) {
            int s = curLines.get(i).start;
            int e = curLines.get(i).end;

            if (s <= currentEnd) {
                currentEnd = Math.max(currentEnd, e);
            } else {
                area += currentEnd - currentStart;
                currentStart = s;
                currentEnd = e;
            }
        }
        area += currentEnd - currentStart;
        return area;
    }

    public void addSquare(int x, int y, int w, int h){
        for (int i=y; i<y+h; i++){
            squares[i].add(new Line(x, x+w));
        }
    }
}