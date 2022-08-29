#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
int n,m;
bool check[1005];
bool kt;
void DFS(int u, int v){
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
       int j=List[u][i];
       if(check[j]==true) DFS(j,u);
       else if(j!=v) kt=true;
    }
}
void chu_trinh(){
    kt=false;
    for(int i=1;i<=n;i++){
        memset(check,true,sizeof(check));
        DFS(i,0);
        if(kt==true){
            cout << "YES" << endl;
            return;
        }
    }
    cout << "NO" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        memset(check,true,sizeof(check));
        cin>>n>>m;
        for(int i=0;i<1005;i++) List[i].clear();
        for(int i=1;i<=m;i++){
            int x,y; cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        chu_trinh();
    }
}
