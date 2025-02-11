import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LineSegment[] lines = new LineSegment[n];
        
        for (int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            
            lines[i]=new LineSegment(x,y);
        }
        br.close();

        System.out.println(sumLinesLength(lines));
    }

    public static int sumLinesLength(LineSegment[] lines){
        Arrays.sort(lines, new LineComparator());
        int sum=0;
        int start=lines[0].start;
        int end=lines[0].end;
        
        for (LineSegment line:lines){
            if(line.start<=end){
                end=Math.max(end,line.end);
            } else{
                sum+=end-start;
                start=line.start;
                end=line.end;
            }
        }
        sum+=end-start;
        
        return sum;
    }
}

class LineSegment{
    int start;
    int end;
    char isStart;
    int pos;

    public LineSegment(int start, int end){
        this.start=start;
        this.end=end;
    }
}

class LineComparator implements Comparator<LineSegment> {
    public int compare(LineSegment o1, LineSegment o2){
        if(o1.start!=o2.start){
            return o1.start-o2.start;
        }

        return o1.end-o2.end;
    }
}