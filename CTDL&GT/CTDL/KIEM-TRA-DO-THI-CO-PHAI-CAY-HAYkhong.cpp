#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int n;
void BFS(int u){
    check[u]=false;
    queue<int> Q;
    Q.push(u);
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int k=List[j][i];
            if(check[k]==true){
                check[k]=false;
                Q.push(k);
            }
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(check,true,sizeof(check));
        for(int i=0;i<1005;i++) List[i].clear();
        cin>>n;
        for(int i=1;i<n;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        BFS(1);
        int kt=1;
        for(int i=1;i<=n;i++){
            if(check[i]==true){
                kt=0;
                break;
            }
        }
        if(kt==0) cout << "NO" << endl;
        else cout << "YES" << endl;
    }
}