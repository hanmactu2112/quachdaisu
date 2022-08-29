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
void dinh_tru(){
    for(int i=1;i<=n;i++){
        int kt=0;
        memset(check,true,sizeof(check));
        check[i]=false;
        if(i==1) DFS(2);
        else DFS(1);
        for(int k=1;k<=n;k++){
            if(check[k]==true){
                kt=1;
                break;
            }
        }
        if(kt==1) cout << i << " ";
    }
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m;
        for(int i=0;i<1005;i++) List[i].clear();
        for(int i=1;i<=m;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        dinh_tru();
        cout << endl;
    }
}