#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
int n,m;
int check[1005],kt=0;
void BFS(int u){
    queue<int> Q;
    Q.push(u);
    check[u]=1;
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int k=List[j][i];
            if(check[k]==0){
                check[k]=1;
                Q.push(k);
            }
            else if(check[k]==1) kt=1;
        }
        check[j]=2;
    }
}
void xuly(){
    kt=0;
    for(int i=1;i<=n;i++){
        memset(check,0,sizeof(check));
        BFS(i);
        if(kt==1){
            cout << "YES" << endl;
            return;
        }
    }
    cout << "NO" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y; cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        xuly();
    }
}