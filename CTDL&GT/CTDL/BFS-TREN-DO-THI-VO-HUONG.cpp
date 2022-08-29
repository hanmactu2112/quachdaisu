#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
void BFS(int u){
    queue<int> Q;
    check[u]=false;
    cout << u << " ";
    Q.push(u);
    while(!Q.empty()){
        int k=Q.front();
        Q.pop();
        for(int i=0;i<List[k].size();i++){
            int j=List[k][i];
            if(check[j]==true){
                cout << j << " ";
                check[j]=false;
                Q.push(j);
            }
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
            //List[y].push_back(x);
        }
        BFS(u);
        cout << endl;
    }
}