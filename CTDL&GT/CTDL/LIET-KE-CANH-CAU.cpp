#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int n,m;
void DFS(int u, int x, int y){
    check[u]=false;
    for(int i=0;i<List[u].size();i++){
        int j=List[u][i];
        if((u==x&&j==y)||(u==y&&j==x)) continue;
        else if(check[j]==true) DFS(j,x,y);
    }
}
void canh_cau(){
    for(int i=1;i<=n;i++){
        for(int j=0;j<List[i].size();j++){
            memset(check,true,sizeof(check));
            int u=List[i][j];
            int res=0;
            for(int k=1;k<=n;k++){
                if(check[k]==true){
                    res++;
                    DFS(k,i,u);
                }
            }
            if(res>1&&u>i) cout << i << " " << u << " ";
        }
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
        canh_cau();
        cout << endl;
    }
}