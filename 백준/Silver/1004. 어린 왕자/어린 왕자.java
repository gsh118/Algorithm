import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t=Integer.parseInt(br.readLine());
        for (int i=0; i<t; i++){
            st=new StringTokenizer(br.readLine());
            int[] p = new int[4];

            for (int j=0; j<4; j++){
                p[j]=Integer.parseInt(st.nextToken());
            }
            Point start = new Point(p[0],p[1]);
            Point end = new Point(p[2],p[3]);

            int n = Integer.parseInt(br.readLine());

            Circle[] circles = new Circle[n];
            for (int j=0; j<n; j++){
                st=new StringTokenizer(br.readLine());
                int[] c = new int[3];
                for (int k=0; k<3; k++){
                    c[k]=Integer.parseInt(st.nextToken());
                }
                circles[j]=new Circle(new Point(c[0],c[1]),c[2]);
            }

            bw.write(calcMinPassNum(start,end,circles)+"\n");
        }

        br.close();
        bw.close();
    }

    public static int calcMinPassNum(Point start, Point end, Circle[] circles){
        int cnt=0;
        for (Circle c:circles){
            if(c.isInside(start) ^ c.isInside(end)){
                cnt++;
            }
        }
        return cnt;
    }

}
class Point{
    double x;
    double y;
    public Point(double x, double y){
        this.x=x;
        this.y=y;
    }

    public double dist(Point o){
        return Math.pow((x-o.x)*(x-o.x)+(y-o.y)*(y-o.y), 0.5);
    }
}

class Circle{
    Point c;
    double rad;
    public Circle(Point c, double rad){
        this.c=c;
        this.rad=rad;
    }

    public boolean isInside(Point x){
        return c.dist(x)<=rad;
    }
}