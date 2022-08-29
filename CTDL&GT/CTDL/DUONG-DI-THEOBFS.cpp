#include<bits/stdc++.h>
using namespace std;
vector<int> List[1005];
bool check[1005];
int trace[1005];
int n,m,st,en;
void BFS(int u){
    queue<int> Q;
    Q.push(u);
    check[u]=false;
    while(!Q.empty()){
        int i=Q.front();
        Q.pop();
        for(int j=0;j<List[i].size();j++){
            int k=List[i][j];
            if(check[k]==true){
                trace[k]=i;
                Q.push(k);
                check[k]=false;
            }
        }
    }
}
void tim_duong(){
    BFS(st);
    if(check[en]==true){
        cout << "-1";
    }
    else {
        stack<int> a;
        a.push(en);
        while(st!=en){
            en=trace[en];
            a.push(en);
        }
        while(!a.empty()){
            cout << a.top() << " ";
            a.pop(); 
        }
    }
    cout << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        for(int i=0;i<1005;i++) List[i].clear();
        memset(check,true,sizeof(check));
        cin>>n>>m>>st>>en;
        for(int i=0;i<m;i++){
            int x,y;
            cin>>x>>y;
            List[x].push_back(y);
        }
        tim_duong();
    }
}