#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
/*void BFS(int u){
    check[u]=false;
    queue<int> Q;
    Q.push(u);
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int k=List[j][i];
            if(check[k]==true){
                check[k]=false;
                Q.push(k);
            }
        }
    }
}*/
void DFS(int u){
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
        int n,m; cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y; cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        int dem=0;
        for(int i=1;i<=n;i++){
            if(check[i]==true){
                dem++;
                DFS(i);
            }
        }
        cout << dem << endl;
    }
}