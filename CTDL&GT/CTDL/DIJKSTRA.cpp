#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> List[1005];
int D[1005],check[1005];
int n,m,st;
void DIJKSTRA(){
    priority_queue<pair<int,int>,vector<pair<int,int>>, greater<pair<int,int>>> Q;
    for(int i=1;i<1005;i++){
        D[i]=1e9;
    }
    while(!Q.empty()) Q.pop();
    Q.push({0,st});
    D[st]=0;
    while(!Q.empty()){
        pair<int,int> p=Q.top();
        Q.pop();
        int u=p.second;
        for(int i=0;i<List[u].size();i++){
            int v=List[u][i].first;
            int d_u_v=List[u][i].second;
            if(D[u]+d_u_v<D[v]){
                D[v]=D[u]+d_u_v;
                Q.push({D[v],v});
            }
        }
    }
    for(int i=1;i<=n;i++){
        cout << D[i] << " ";
    }
    cout << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m>>st;
        for(int i=0;i<1005;i++) List[i].clear();
        for(int i=0;i<m;i++){
            int x,y,z;
            cin>>x>>y>>z;
            List[x].push_back({y,z});
            List[y].push_back({x,z});
        }
        DIJKSTRA();
    }
}