#include<bits/stdc++.h>
#define MAX 101
using namespace std;
int a[MAX][MAX];
bool vs[MAX];
int trace[MAX];
int n, m;
void DFS(int u){
    //cout << u << " ";
    vs[u]=true;
    for(int i=1;i<=n;i++){
        if(a[u][i]==1 && vs[i]==false){
            trace[i]=u;
            DFS(i);
        }
    }
}
int main(){
    memset(a,0,sizeof(a));
    memset(vs,false,sizeof(vs));
    memset(trace,-1,sizeof(trace));
    int u,v,s,f;
    cin >> n >> m >> s >> f;
    for(int i=0;i<m;i++){
        cin >> u >> v;
        a[u][v]=1;
        a[v][u]=1;
    }
    DFS(s);
    if(trace[f]==-1) cout << "not found" ;
    else {
        int res[MAX]; int k=0;
        while(f!=s){
            res[++k]=f;
            f=trace[f];
        }
        res[++k]=s;
        for(int i=k;i>=1;i--){
            cout << res[i]<<" ";
        }
    }
}
