#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
void DFS(int u){
    cout << u << " ";
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[j]==true){
            DFS(j);
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        memset(check,true,sizeof(check));
        int n,m,u;
        cin>>n>>m>>u;
        for(int i=1;i<=m;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        DFS(u);
        cout << endl;
    }
}