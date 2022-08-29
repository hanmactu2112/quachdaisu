#include<bits/stdc++.h>
#define MAX 101
using namespace std;
int n,m,u,v;
int a[MAX][MAX];
bool vs[MAX];
int trace[MAX];
void BFS(int u){
    queue<int> d;
    vs[u]=true;
    d.push(u);
    while(!d.empty()){
        int x=d.front();
        d.pop();
        for(int i=1;i<=n;i++){
            if(a[x][i]==1&&vs[i]==false){
                trace[i]=x;
                d.push(i);
                vs[i]=true;
            }
        }
    }
}
main(){
    int t; cin >> t;
    while(t--){
    memset(a,0,sizeof(a));
    memset(vs,false,sizeof(vs));
    memset(trace,-1,sizeof(trace));
    cin>>n>>m;
    for(int i=0;i<m;i++){
        cin>>u>>v;
        a[u][v]=1;
        a[v][u]=1;
    }
    int dem=0;
    for(int i=1;i<=n;i++){
        if(vs[i]==false){
            dem++;
            BFS(i);
        }
    }
        for(int i=1;i<=n;i++){
        memset(vs,false,sizeof(vs));
        int dem1=0;
        vs[i]=true;
        for(int j=1;j<=n;j++){
            if(vs[j]==false){
                dem1++;
                BFS(j);
            }
        }

        if(dem1>dem) cout << i << " ";
    }
    cout << endl;
    }
}

