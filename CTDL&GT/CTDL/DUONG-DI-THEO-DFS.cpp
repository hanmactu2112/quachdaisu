#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int trace[1005];
int n,m,st,en;
void DFS(int u){
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[j]==true){
            check[j]=false;
            trace[j]=u;
            DFS(j);
        }
    }
}
void xuly(){
    DFS(st);
    int a[1005],dem=0;
    if(check[en]==true){
        cout << "-1";
    }
    else {
        a[++dem]=en;
        while(en!=st){
            en=trace[en];
            a[++dem]=en;
        }
        for(int i=dem;i>=1;i--){
            cout << a[i] << " ";
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m>>st>>en;
        memset(check,true,sizeof(check));
        for(int i=0;i<1005;i++) List[i].clear();
        for(int i=0;i<m;i++){
            int u,v;
            cin>>u>>v;
            List[u].push_back(v);
            //List[v].push_back(u);
        }
        xuly();
        cout << endl;
    }
}
