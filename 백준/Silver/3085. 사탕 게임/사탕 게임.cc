#include <iostream>
#include <string>
using namespace std;

int chkbrd(string *arr, int n){
    int mx=0;
    int cnt1=0,cnt2=0;
    
    for (int i=0; i<n; i++){
        char prev1=0;
        char prev2=0;
        for(int j=0; j<n; j++){         
            if(prev1!=arr[i][j]){
                cnt1=1;
            } else{
                cnt1++;
            }
            prev1=arr[i][j];
            if(cnt1>mx){mx=cnt1;}
            if(prev2!=arr[j][i]){
                cnt2=1;
            } else{
                cnt2++;
            }
            prev2=arr[j][i];
            if(cnt2>mx){mx=cnt2;}
        }
    }
    return mx;
}

int permbrd(string *arr, int n){
    int mx=0;  
    int ct;
    int dx[2]={0,1};
    int dy[2]={1,0};
    char tmp;
    for (int i=0; i<n; i++){
        for(int j=0; j<n; j++){
            for(int k=0; k<2; k++){
                int nx=i+dx[k];
                int ny=j+dy[k];
                if (0<=nx&& nx<n && 0<=ny && ny<n){
                    tmp=arr[i][j];
                    arr[i][j]=arr[nx][ny];
                    arr[nx][ny]=tmp;
                    ct=chkbrd(arr,n);
                    if(ct>mx){mx=ct;
                      }
                    tmp=arr[i][j];
                    arr[i][j]=arr[nx][ny];
                    arr[nx][ny]=tmp;
                }
            }
        }
    }
    return mx;
}

int main(void){
    int n;
    cin>>n;
    string *brd=new string[n];
    for (int i=0; i<n; i++){
        cin>>brd[i];
    }
    cout<<permbrd(brd,n);
}