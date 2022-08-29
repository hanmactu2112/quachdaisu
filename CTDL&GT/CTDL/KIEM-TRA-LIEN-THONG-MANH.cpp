#include<bits/stdc++.h>
using namespace std;
int n,m,num[100005],low[100005];
int dem;
vector<int> a[100005];
stack<int> st;
int solt;
void visit(int u){
    low[u]=num[u]=++dem;
    st.push(u);
    for(auto v:a[u]){
        if(num[v]){
            low[u]=min(low[u],num[v]);
        }
        else{
            visit(v);
            low[u]=min(low[u],low[v]);
        }
    }
    if(num[u]==low[u]){
        solt++;
        int v;
        do{
            v=st.top();
            st.pop();
            num[v]=low[v]=0x3c3c3c3c;
        }
        while(v!=u);
    }
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<100005;i++) a[i].clear();
        while(!st.empty()) st.pop();
        memset(num,0,sizeof(num));
        memset(low,0,sizeof(low));
        cin>>n>>m;
        for(int i=0;i<m;i++){
            int x,y; cin>>x>>y;
            a[x].push_back(y);
        }
        dem=0;
        solt=0;
        for(int i=1;i<=n;i++){
            if(!num[i]) visit(i);
        }
        cout << solt << endl;
        /*if(solt==1){
            cout << "YES" << endl;
        }
        else{
            cout << "NO" << " " << solt << endl;
        }*/
    }
}