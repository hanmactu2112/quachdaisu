#include<bits/stdc++.h>
using namespace std;
vector<int> List[100005];
int n,m,dem,ans;
bool vs[100005];
void DFS(int u){
    vs[u]=true;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(vs[j]==false){
            dem++;
            DFS(j);
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(vs,false,sizeof(vs));
        for(int i=0;i<100005;i++) List[i].clear();
        cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        ans=-1;
        for(int i=1;i<=n;i++){
            if(vs[i]==false){
                dem=1;
                DFS(i);
                ans=max(ans,dem);
            }
        }
        cout << ans << endl;
    }
}