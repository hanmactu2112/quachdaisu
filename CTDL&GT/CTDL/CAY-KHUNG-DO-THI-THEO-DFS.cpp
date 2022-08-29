#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> a;
int n,m,v;
vector<int> List[1005];
bool check[1005];
void DFS(int u){
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[j]==true){
            a.push_back({u,j});
            DFS(j);
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m>>v;
        for(int i=0;i<1005;i++) List[i].clear();
        memset(check,true,sizeof(check));
        a.clear();
        for(int i=0;i<m;i++){
            int u,v;
            cin>>u>>v;
            List[u].push_back(v);
            List[v].push_back(u);
        }
        DFS(v);
        if(a.size()==n-1){
            for(int i=0;i<a.size();i++){
                cout << a[i].first << " " << a[i].second << endl;
            }
        } else cout << "-1";
        cout << endl;
    }
}