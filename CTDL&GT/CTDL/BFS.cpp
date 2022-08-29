#include<bits/stdc++.h>
#define MAX 101
using namespace std;
int n,m,u,v,f,s;
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
    //freopen("BFS.INP","r",stdin);
    //freopen("BFS.OUT","w",stdout);
    memset(a,0,sizeof(a));
    memset(vs,false,sizeof(vs));
    memset(trace,-1,sizeof(trace));
    cin>>n>>m>>f>>s;
    for(int i=0;i<m;i++){
        cin>>u>>v;
        a[u][v]=1;
        a[v][u]=1;
    }
    BFS(f);

    /*
    if(trace[s]==-1) cout << "not found";
    else{
        int res[MAX];
        int k=0;
        while(s!=f){
            res[++k]=s;
            s=trace[s];
        }
        res[++k]=f;
        for(int i=k;i>=1;i--){
            cout << res[i] << " ";
        }
    }
    */
}
