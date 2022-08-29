#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
int dem[1005];
bool check[1005];
int a[105],n,m,k;
void BFS(int u){
    queue<int> Q;
    Q.push(u);
    dem[u]++;
    check[u]=false;
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int k=List[j][i];
            if(check[k]==true){
                dem[k]++;
                Q.push(k);
                check[k]=false;
            }
        }
    }
}
main(){
    cin>>k>>n>>m;
    for(int i=0;i<k;i++){
        cin>>a[i];
    }
    memset(dem,0,sizeof(dem));
    for(int i=1;i<=m;i++){
        int x,y; cin>>x>>y;
        List[x].push_back(y);
    }
    for(int i=0;i<k;i++){
        memset(check,true,sizeof(check));
        BFS(a[i]);
    }
    int ans=0;
    for(int i=1;i<=n;i++){
        if(dem[i]==k){
            ans++;
        }
    }
    cout << ans << endl;
}