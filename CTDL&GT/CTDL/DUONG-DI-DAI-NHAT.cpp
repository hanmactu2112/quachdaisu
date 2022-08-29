#include<bits/stdc++.h>
using namespace std;
int ans,n,m;
bool check[25][25];
vector<int> List[25];
void tim_duong(int u, int res){
    ans=max(ans,res);
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[u][j]==false){
            check[u][j]=check[j][u]=true;
            tim_duong(j,res+1);
            check[u][j]=check[j][u]=false;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(check,false,sizeof(check));
        for(int i=0;i<25;i++) List[i].clear();
        cin>>n>>m;
        for(int i=0;i<m;i++){
            int u,v; cin>>u>>v;
            List[u].push_back(v);
            List[v].push_back(u);
        } 
        ans=0;
        for(int i=0;i<n;i++){
            memset(check,false,sizeof(check));
            tim_duong(i,0);
        }
        cout << ans << endl;
    }
}