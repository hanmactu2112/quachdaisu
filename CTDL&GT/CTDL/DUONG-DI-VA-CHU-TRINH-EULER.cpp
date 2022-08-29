#include<bits/stdc++.h>
using namespace std;
#define MAX 1000+5
int a[MAX][MAX];
bool vs[MAX];
int dem,n,m;
void DFS(int u){
    dem++;
    vs[u]=true;
    for(int i=1;i<=n;i++){
        if(vs[i]==false && a[u][i]==1){
            DFS(i);
        }
    }
}
void xuly(){
    int demle=0;
    for(int i=1;i<=n;i++){
        int dem=0;
        for(int j=1;j<=n;j++){
            if(a[i][j]==1) dem++;
        }
        if(dem%2!=0) demle++;
    }
    if(demle==0) cout << "2" << endl;
    else if(demle==2) cout << "1" << endl;
    else cout << "0" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        memset(a,0,sizeof(a));
        memset(vs,false,sizeof(vs));
        cin>>n>>m;
        int u,v;
        for(int i=1;i<=m;i++){
            cin>>u>>v;
            a[u][v]=1;
            a[v][u]=1;
        }
        dem=0;
        DFS(1);
        if(dem!=n) cout << "0" << endl;
        else {
            xuly();
        }
    } 
}