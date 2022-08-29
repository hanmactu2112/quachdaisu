#include<bits/stdc++.h>
using namespace std;
int KT[1005][1005];
int a[1005][1005];
int n,m;
void xuly(){
    memset(KT,-1,sizeof(KT));
    queue<pair<int,int>> Q;
    Q.push({1,1});
    KT[1][1]=0;
    while(!Q.empty()){
        int x=Q.front().first;
        int y=Q.front().second;
        Q.pop();
        if(x==n&&y==m){
            cout << KT[n][m] << endl;
            return;
        }
        int xuong=abs(a[x][y]-a[x+1][y]);
        int sang=abs(a[x][y]-a[x][y+1]);
        int cheo=abs(a[x][y]-a[x+1][y+1]);
        if(x+xuong<=n&&KT[x+xuong][y]==-1){
            Q.push({x+xuong,y});
            KT[x+xuong][y]=KT[x][y]+1;
        }
        if(y+sang<=m&&KT[x][y+sang]==-1){
            KT[x][y+sang]=KT[x][y]+1;
            Q.push({x,y+sang});
        }
        if(x+cheo<=n&&y+cheo<=m&&KT[x+cheo][y+cheo]==-1){
            Q.push({x+cheo,y+cheo});
            KT[x+cheo][y+cheo]=KT[x][y]+1;
        }
    }
    cout << "-1" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m;
        memset(a,0,sizeof(a));
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                cin>>a[i][j];
            }
        }
        xuly();
    }
}
