#include<bits/stdc++.h>
using namespace std;
int a[505][505],n,m;
bool check[505][505];
int d1[8]={-1,-1,-1,0,0,1,1,1};
int d2[8]={-1,0,1,-1,1,-1,0,1};
void tim_dao(int x,int y){
    queue<pair<int,int>> Q;
    Q.push({x,y});
    check[x][y]=false;
    while(!Q.empty()){
        pair<int,int> p=Q.front();
        Q.pop();
        for(int i=0;i<8;i++){
            int id1=p.first+d1[i];
            int id2=p.second+d2[i];
            if(a[id1][id2]==1 && check[id1][id2]==true){
                check[id1][id2]=false;
                Q.push({id1,id2});
            }
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(a,0,sizeof(a));
        memset(check,true,sizeof(check));
        cin>>n>>m;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                cin>>a[i][j];
            }
        }
        int dem=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i][j]==1 && check[i][j]==true){
                    dem++;
                    tim_dao(i,j);
                }
            }
        }
        cout << dem << endl;
    }
}