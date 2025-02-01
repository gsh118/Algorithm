import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        LectureEvent[] events = new LectureEvent[2*n];
        for (int i=0; i<2*n; i+=2) {
            st = new StringTokenizer(br.readLine());
            events[i] = new LectureEvent(Integer.parseInt(st.nextToken()), (char) 0);
            events[i + 1] = new LectureEvent(Integer.parseInt(st.nextToken()), (char) 1);
        }

        Arrays.sort(events, new EventComparator());

        int solution = doEvent(events);
        System.out.println(solution);
    }

    private static int doEvent(LectureEvent[] events){
        int max=0;
        int cur=0;

        int n = events.length;
        for (LectureEvent event : events) {
            if (event.endFlag == 0) {
                cur += 1;
                max = Math.max(cur, max);
            } else {
                cur -= 1;
            }
        }

        return max;
    }
}

class LectureEvent{
    public int time;
    public char endFlag;

    public LectureEvent(int time, char endFlag) {
        this.time = time;
        this.endFlag = endFlag;
    }
}

class EventComparator implements Comparator<LectureEvent> {
    @Override
    public int compare(LectureEvent o1, LectureEvent o2) {
        if(o1.time!=o2.time){
            return o1.time-o2.time;
        }

        return o2.endFlag-o1.endFlag;
    }
}
