import java.util.*;
import java.io.*;
import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<List<Integer>> fishTank = new ArrayList<>();
        fishTank.add(new ArrayList<>());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++){
            fishTank.get(0).add(Integer.parseInt(st.nextToken()));
        }

        FishTank ft = new FishTank(fishTank);
        
        int cnt=0;
        while(ft.maxDifference()>k){
            cnt++;
            ft.cleaning();
        }

        System.out.println(cnt);
    }
}

class FishTank {
    private List<List<Integer>> fishTank;
    public FishTank(List<List<Integer>> fishTank) {
        this.fishTank = fishTank;
    }

    public int maxDifference(){
        List<Integer> fishTankLine = fishTank.get(0);
        int min = fishTankLine.get(0);
        int max = min;

        for (int e : fishTankLine){
            if(e>max){
                max=e;
            }
            if(e<min){
                min=e;
            }
        }

        return max-min;
    }

    public void cleaning(){
        addFishToMinTank();
        stackLeftTank();
        rotateAndStack();
        adjustDifference();
        fishTankToOneDimCol();
        rotateLeftHalfAndStack();
        rotateLeftHalfAndStack();
        adjustDifference();
        fishTankToOneDimCol();
    }

    void addFishToMinTank(){
        int minFish = findMinFishNum();

        fishTank.set(0, fishTank.get(0).stream()
                .map(x->(x==minFish?x+1:x))
                .collect(toList()));
    }

    int findMinFishNum(){
        return fishTank.get(0).stream().mapToInt(x->x).min().orElse(-1);
    }

    void stackLeftTank(){
        fishTank.add(new ArrayList<>());
        fishTank.get(1).add(fishTank.get(0).get(0));

        fishTank.set(0, fishTank.get(0).stream()
                .skip(1)
                .collect(toList()));
    }

    void rotateAndStack(){
        while (canRotate()){
            rotateHelper();
        }
    }
    
    boolean canRotate(){
        int stackedHeight = fishTank.size();
        int stackedWidth = fishTank.get(stackedHeight-1).size();

        return fishTank.get(0).size()-stackedWidth>=stackedHeight;
    }

    void rotateHelper(){
        int stackedHeight = fishTank.size();
        int stackedWidth = fishTank.get(stackedHeight-1).size();
        List<List<Integer>> newFishTank = new ArrayList<>();

        newFishTank.add(
                fishTank.get(0).stream()
                        .skip(stackedWidth)
                        .collect(toList())
        );

        for (int i=stackedWidth-1; i>=0; i--){
            List<Integer> line = new ArrayList<>();
            for (int j=0; j<stackedHeight; j++){
                line.add(fishTank.get(j).get(i));
            }
            newFishTank.add(line);
        }

        fishTank = newFishTank;
    }

    void adjustDifference(){
        int[] dx={0,1,0,-1};
        int[] dy={1,0,-1,0};

        List<List<Integer>> newFishTank = new ArrayList<>();

        for (int i=0; i<fishTank.size(); i++){
            newFishTank.add(new ArrayList<>());
            for (int j=0; j<fishTank.get(i).size(); j++){
                int delta = 0;
                for (int k=0; k<4; k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];
                    if (isValidIndex(nx,ny)){
                        delta+=(fishTank.get(nx).get(ny)-fishTank.get(i).get(j))/5;
                    }
                }
                newFishTank.get(i).add(fishTank.get(i).get(j)+delta);
            }
        }

        fishTank = newFishTank;
    }

    boolean isValidIndex(int x, int y){
        int xSize =  fishTank.size();
        if (x>=xSize || x<0){
            return false;
        }

        int ySize = fishTank.get(x).size();
        return y < ySize && y>=0;
    }

    void rotateLeftHalfAndStack(){
        List<List<Integer>> newFishTank = stackRightHalf();
        List<List<Integer>> stacked = stackLeftHalfReversed();
        newFishTank.addAll(stacked);
        fishTank = newFishTank;
    }

    List<List<Integer>> stackRightHalf(){
        return fishTank.stream()
                .map(line-> line.stream()
                        .skip(line.size()/2)
                        .collect(toList())
                ).collect(toList());
    }

    List<List<Integer>> stackLeftHalfReversed(){
        Collections.reverse(fishTank);
        return fishTank.stream()
                .map(line->{
                    Collections.reverse(line);
                    return line.stream()
                            .skip(line.size()/2)
                            .collect(toList());
                })
                .collect(toList());
    }

    void fishTankToOneDimCol(){
        List<List<Integer>> newFishTank = new ArrayList<>();
        newFishTank.add(new ArrayList<>());

        for (int y=0; y<fishTank.get(0).size(); y++){
            for (int x=0; x<fishTank.size(); x++) {
                if(isValidIndex(x,y)){
                    newFishTank.get(0).add(fishTank.get(x).get(y));
                }
            }
        }
        fishTank = newFishTank;
    }
}