#include<bits/stdc++.h>
#define MAX 505
using namespace std;
int a[MAX][MAX];
bool vs[MAX];
int trace[MAX];
int n, m;
vector<vector<int>> op;
vector<int> op1;
void BFS(int u){
    queue<int> d;
    vs[u]=true;
    d.push(u);
    op1.push_back(u);
    while(!d.empty()){
        int x=d.front();
        d.pop();
        for(int i=1;i<=n;i++){
            if(a[x][i]==1&&vs[i]==false){
                trace[i]=x;
                d.push(i);
                op1.push_back(i);
                vs[i]=true;
            }
        }
    }
    //sort(op1.begin(),op1.end());
    op.push_back(op1);
}
int main(){
    memset(a,0,sizeof(a));
    memset(vs,false,sizeof(vs));
    memset(trace,-1,sizeof(trace));
    cin>>n;
    cin>>m;
    /*
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            cin>>a[i][j];
        }
    }
    */
    int u,v;
    for(int i=1;i<=m;i++){
        cin>>u>>v;
        a[u][v]=1;
        a[v][u]=1;
    }
    int dem=0;
    for(int i=1;i<=n;i++){
        if(vs[i]==false){
            op1.clear();
            dem++;
            BFS(i);
        }
    }
    cout << dem << endl;
    int i1=op.size();
    for(int i=0;i<i1;i++){
        int ix=op[i].size();
        for(int j=0;j<ix;j++){
            cout << op[i][j] << " ";
        }
        cout << endl;
    }
}
