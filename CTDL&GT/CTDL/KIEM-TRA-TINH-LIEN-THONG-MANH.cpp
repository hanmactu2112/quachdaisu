#include<bits/stdc++.h>
using namespace std;
#define MAX 1000+5
bool vs[MAX];
int a[MAX][MAX], n, m;
int dem;
void DFS(int u){
    dem++;
    vs[u]=true;
    for(int i=1;i<=n;i++){
        if(vs[i]==false && a[u][i]==1){
            vs[i]=true;
            DFS(i);
        }
    }
}
main(){
    int t; cin>>t;
    while (t--){
        cin>>n>>m;
        int u,v; 
        memset(a,0,sizeof(a));
        for(int i=1;i<=m;i++){
            cin>>u>>v;
            a[u][v]=1;
        }
        int ok=1;
        for(int i=1;i<=n;i++){
            memset(vs,false,sizeof(vs));
            dem=0;
            DFS(i);
            if(dem!=n){
                ok=0;
                break;
            }
            if(ok==0) break;
        }
        if(ok==1) cout << "YES" << endl;
        else cout << "NO" << endl;
    }
    
}
