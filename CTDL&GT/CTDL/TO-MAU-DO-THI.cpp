#include<bits/stdc++.h>
using namespace std;
vector<pair<int,int>> p;
vector<int> List[1005];
bool check[1005];
int a[105][105];
int n,m,max_1;
bool cmp(pair<int,int> a, pair<int,int> b){
    return a.first>b.first;
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        cin>>n>>m>>max_1;
        memset(a,0,sizeof(a));
        for(int i=0;i<m;i++){
            int x,y; cin>>x>>y;
            a[x][y]=a[y][x]=1;
            List[x].push_back(y);
            List[y].push_back(x);
        }
        for(int i=1;i<=n;i++){
            p.push_back({List[i].size(),i});
        }
        sort(p.begin(),p.end(),cmp);
        int dem=0;
        memset(check,true,sizeof(check));
        for(auto it:p){
            int u=it.second;
            if(check[u]==false) continue;
            check[u]=false;
            dem++;
            for(int i=1;i<=n;i++){
                if(a[u][i]==0){
                    check[i]=false;
                }
            }
        }
        if(dem<=max_1) cout  << "YES" << endl;
        else cout << "NO" << endl;
    }
}