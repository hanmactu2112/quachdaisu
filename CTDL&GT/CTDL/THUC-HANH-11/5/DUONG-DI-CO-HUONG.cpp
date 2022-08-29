#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int n,m,sta,en;
int trace[1005];
void BFS(int u){
    queue<int> Q;
    Q.push(u);
    check[u]=false;
    while(!Q.empty()){
        int j=Q.front();
        Q.pop();
        for(int i=0;i<List[j].size();i++){
            int v=List[j][i];
            if(check[v]==true){
                check[v]=false;
                trace[v]=j;
                Q.push(v);
            }
        }
    }
}
void duong_di(){
    memset(check,true,sizeof(check));
    BFS(sta);
    if(check[en]==true){
        cout << "-1";
    }
    else {
        stack<int> st;
        st.push(en);
        while(en!=sta){
            en=trace[en];
            st.push(en);
        }
        while(!st.empty()){
            cout << st.top() << " ";
            st.pop();
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m>>sta>>en;
        for(int i=0;i<1005;i++) List[i].clear();
        memset(check,true,sizeof(check));
        for(int i=0;i<m;i++){
            int u,v;
            cin>>u>>v;
            List[u].push_back(v);
        }
        duong_di();
        cout << endl;
    }
}