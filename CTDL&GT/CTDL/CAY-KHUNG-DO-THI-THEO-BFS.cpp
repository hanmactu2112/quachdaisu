#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> p;
int n,m,st;
bool check[1005];
vector<int> List[1005];
void BFS(int u){
    queue<int> Q;
    Q.push(u);
    check[u]=false;
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int v=List[j][i];
            if(check[v]==true){
                check[v]=false;
                Q.push(v);
                p.push_back({j,v});
            }
        }
    }
}
void cay_khung(){
    BFS(st);
    if(p.size()!=n-1){
        cout << "-1" << endl;
    }
    else {
        for(int i=0;i<p.size();i++){
            cout << p[i].first << " " << p[i].second << endl;         
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        p.clear();
        memset(check,true,sizeof(check));
        cin>>n>>m>>st;
        for(int i=0;i<1005;i++) List[i].clear();
        for(int i=0;i<m;i++){
            int u,v;
            cin>>u>>v;
            List[u].push_back(v);
            List[v].push_back(u);
        }
        cay_khung();
    }
}