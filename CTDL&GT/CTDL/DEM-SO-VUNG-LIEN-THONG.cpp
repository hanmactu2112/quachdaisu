#include<bits/stdc++.h>
#define MAX 505
using namespace std;
int a[MAX][MAX];
bool vs[MAX];
int trace[MAX];
int n, m;
vector<vector<int>> op;
vector<int> op1;
void DFS(int u){
    vs[u]=true;
    op1.push_back(u);
    for(int i=1;i<=n;i++){
        if(a[u][i]==1 && vs[i]==false){
            trace[i]=u;
            DFS(i);
        }
    }
}
int main(){
    memset(a,0,sizeof(a));
    memset(vs,false,sizeof(vs));
    memset(trace,-1,sizeof(trace));
    cin >> n;
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
            DFS(i);
            //sort(op1.begin(),op1.end());
            op.push_back(op1);
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
