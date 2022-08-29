#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
int n,m,kt;
bool check[1005];
void DFS(int i,int dem){
    if(dem==n){
        kt=1;
        return;
    }
    check[i]=false;
    for(int j=0;j<List[i].size();j++){
        int k=List[i][j];
        if(check[k]==true){
            DFS(k,dem+1);
            check[k]=true;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        kt=0;
        for(int i=1;i<=n;i++){
            memset(check,true,sizeof(check));
            DFS(i,1);
            if(kt==1) break;
        }
        if(kt==1) cout << "1" << endl;
        else cout << "0" << endl;
    }
}
