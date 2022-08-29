#include<bits/stdc++.h>
using namespace std;
int d1[8]={-1,-1,-1,0,0,1,1,1};
int d2[8]={-1,0,1,-1,1,-1,0,1};
char a[505][505];
bool check[505][505];
int n,m;
void tim_ao(int x,int y){
    queue<pair<int,int>> Q;
    Q.push({x,y});
    check[x][y]=true;
    while(!Q.empty()){
        pair<int,int> p=Q.front();
        Q.pop();
        for(int i=0;i<8;i++){
            int id1=p.first+d1[i];
            int id2=p.second+d2[i];
            if(id1>=1&& id1<=n && id2>=1&&id2<=m && a[id1][id2]=='W' && check[id1][id2]==false){
                Q.push({id1,id2});
                check[id1][id2]=true;
            }
        }
    }
}
main(){
    cin>>n>>m;
    cin.ignore();
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            cin>>a[i][j];
        }
    }
    int d=0;
    memset(check,false,sizeof(check));
    for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
            if(check[i][j]==false&&a[i][j]=='W'){
                d++;
                tim_ao(i,j);
            }
        }
    }
    cout << d << endl;
}