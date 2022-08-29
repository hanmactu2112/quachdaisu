#include<bits/stdc++.h>
using namespace std;
struct dscanh{
    int u,v,w;
};
bool cmp(dscanh a, dscanh b){
    return a.w<b.w;
}
int parent[1005],sz[1005];
int n,m;
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
        sz[a]=sz[a]+sz[b];
        return true;
    }
}
vector<dscanh> a;
int dodai;
void KRUSKAL(){
    khoi_tao();
    vector<dscanh> mst;
    sort(a.begin(),a.end(),cmp);
    for(int i=0;i<m;i++){
        if(mst.size()==n-1) break;
        struct dscanh e=a[i];
        if(ghep(e.u,e.v)==true){
            dodai=dodai+e.w;
            mst.push_back(e);
        }
    }
    cout << dodai << endl;
    for(int i=0;i<mst.size();i++){
        cout << mst[i].u << " " << mst[i].v << endl;
    }
}
main(){
    int t; cin>>t;
    while(t--){
        dodai=0;
        a.clear();
        cin>>n>>m;
        for(int i=0;i<m;i++){
            int x,y,z;
            cin>>x>>y>>z;
            struct dscanh e;
            e.u=x; e.v=y; e.w=z;
            a.push_back(e);
        }
        KRUSKAL();
    }
}
