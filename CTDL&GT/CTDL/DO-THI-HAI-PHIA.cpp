#include<bits/stdc++.h>
using namespace std;
struct dscanh{
    int u,v;
};
int parent[1005];
int sz[1005];
int n,m;
vector<dscanh> a;
void khoi_tao(){
    for(int i=1;i<=n;i++){
        parent[i]=i;
        sz[i]=1;
    }
}
int find(int x){
    if(x==parent[x]) return x;
    else return find(parent[x]);
}
bool ghep(int x, int y){
    int a=find(x);
    int b=find(y);
    if(a==b) return false;
    else {
        if(sz[a]<sz[b]) swap(a,b);
        parent[b]=a;
        sz[a]+=sz[b];
        return true;
    }
}
void xuly(){
    khoi_tao();
    vector<dscanh> mst;
    for(int i=0;i<m;i++){
        struct dscanh e = a[i];
        if(ghep(e.u,e.v)) mst.push_back(e);
        else {
            cout << "NO" << endl;
            return; 
        }
    }
    cout << "YES" << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        a.clear();
        cin>>n>>m;
        for(int i=1;i<=m;i++){
            int x,y;
            cin>>x>>y;
            struct dscanh e;
            e.u=x; e.v=y;
            a.push_back(e);
        }
        xuly();
    }
}
