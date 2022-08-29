#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int n,m;
void DFS(int u){
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if(check[j]==true){
            DFS(j);
        }
    }
}
void chia_cat(){
    int ans=-1;
    int dinh=0;
    for(int i=1;i<=n;i++){
        memset(check,true,sizeof(check));
        check[i]=false;
        int res=0;
        for(int i=1;i<=n;i++){
            if(check[i]==true){
                res++;
                DFS(i);
            }
        }
        if(res>ans && res!=1){
            ans=res;
            dinh=i;
        }
    }
    cout << dinh << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        memset(check,true,sizeof(check));
        cin>>n>>m;
        for(int i=0;i<1005;i++) List[i].clear();
        for(int i=1;i<=m;i++){
            int u,v;
            cin>>u>>v;
            List[u].push_back(v);
            List[v].push_back(u);
        }
        chia_cat();
    }
}