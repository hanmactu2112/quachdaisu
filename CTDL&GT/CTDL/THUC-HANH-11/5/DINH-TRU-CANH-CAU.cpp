#include<bits/stdc++.h>
using namespace std;
vector<int> List[100005];
bool check[100005];
int n,m;
int dem1=0;
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
    int ans=0;
    for(int i=1;i<=n;i++){
        int dem=0;
        memset(check,true,sizeof(check));
        check[i]=false;
        if(i==1) DFS(2);
        else DFS(1);
        for(int k=1;k<=n;k++) if(check[k]==true) dem++;
        if(dem>dem1) ans++;
    }
    cout << ans << " ";
}
void canh_cau(){
    int ans=0;
    for(int i=1;i<=n;i++){
        for(int j=0;j<List[i].size();j++){
            int dem=0;
            memset(check,true,sizeof(check));
            int v=List[i][j];
            List[i].erase(List[i].begin()+j);
            DFS(i);
            for(int k=1;k<=n;k++) if(check[k]==true && v>i) dem++;
            if(dem>dem1) ans++;
            List[i].insert(List[i].begin()+j,v); 
        }
    }
    cout << ans << endl;
}
main(){
    for(int i=0;i<100005;i++) List[i].clear();
    cin>>n>>m;
    for(int i=1;i<=m;i++){
        int u,v;
        cin>>u>>v;
        List[u].push_back(v);
        List[v].push_back(u);
    }
    memset(check,true,sizeof(check));
    DFS(1);
    for(int i=1;i<=n;i++) if(check[i]==true) dem1++;
    dinh_tru();
    canh_cau();
}