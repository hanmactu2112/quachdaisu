#include<bits/stdc++.h>
using namespace std;
bool check[10005];
vector<int> List[10005];
int dem,n,m;
void BFS(int u){
    queue<int> Q;
    check[u]=true;
    Q.push(u);
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int k=List[j][i];
            if(check[k]==false){
                Q.push(k);
                check[k]=true;
            }
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        memset(check,false,sizeof(check));
        cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y; cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        BFS(1);
        int kt=0;
        for(int i=1;i<=n;i++){
            if(check[i]==false){
                kt=1;
                break;
            }
        }
        if(kt==1) cout << "NO" << endl;
        else cout << "YES" << endl;
    }
}