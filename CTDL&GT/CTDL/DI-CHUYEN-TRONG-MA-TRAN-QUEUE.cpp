#include<bits/stdc++.h>
using namespace std;
int a[1005][1005];
int kt[1005][1005];
void xuly(int n, int m){
    queue<pair<int,int>> Q;
    memset(kt,-1,sizeof(kt));
    kt[1][1]=0;
    Q.push({1,1});
    while(!Q.empty()){
        pair<int,int> p=Q.front();
        Q.pop();
        int x=p.first;
        int y=p.second;
        if(kt[x][y+a[x][y]]==-1){
            kt[x][y+a[x][y]]=kt[x][y]+1;
            Q.push({x,y+a[x][y]});
        }
        if(kt[x+a[x][y]][y]==-1){
            kt[x+a[x][y]][y]=kt[x][y]+1;
            Q.push({x+a[x][y],y});
        }
        if(kt[n][m]!=-1){
            break;
        }
    }
    cout << kt[n][m] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        int n,m; cin>>n>>m;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                cin>>a[i][j];
            }
        }
        xuly(n,m);
    }
}