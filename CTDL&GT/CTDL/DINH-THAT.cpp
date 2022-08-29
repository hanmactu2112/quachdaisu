#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int n,m,st,en;
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
        cin>>n>>m>>st>>en;
        for(int i=0;i<m;i++){
            int x,y; cin>>x>>y;
            List[x].push_back(y);
            //List[y].push_back(x);
        }
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(i==st||i==en) continue;
            else {
                memset(check,true,sizeof(check));
                check[i]=false;
                DFS(st);
                if(check[en]==true) cnt++;
            }
        }
        cout << cnt << endl;
    }
}