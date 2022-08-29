#include<bits/stdc++.h>
using namespace std;
#define MAX 1000+5
int a[MAX][MAX];
bool vs[MAX];
int n,m;
void DFS(int u){
    vs[u]=true;
    for(int i=1;i<=n;i++){
        if(a[u][i]==1 && vs[i]==false){
            DFS(i);
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(a,0,sizeof(a));
        cin>>n>>m;
        int u,v;
        for(int i=1;i<=m;i++){
            cin>>u>>v;
            a[u][v]=1;
            a[v][u]=1;
        }
        int m; cin>>m;
        int x,y; 
        while(m--){
            memset(vs,false,sizeof(vs));
            cin>>x>>y;
            DFS(x);
            if(vs[y]==false){
                cout << "NO" << endl;
            }
            else cout << "YES" << endl;
        }
    }
}
