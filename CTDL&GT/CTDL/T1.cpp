#include<bits/stdc++.h>
using namespace std;
int a[100][100],n,m,s;

void DIJIK(int u){
    int d[100],e[100];
    for(int i=1;i<=100;i++){
        d[i]=1e9;
        e[i]=u;
    }
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> Q;
    Q.push({0,u});
    d[u]=0;
    while(!Q.empty()){
        pair<int,int> p=Q.top();
        Q.pop();
        int x=p.second;
        for(int i=1;i<=n;i++){
            if(a[x][i]!=0&&d[i]>d[x]+a[x][i]){
                d[i]=d[x]+a[x][i];
                e[i]=x;
                a[x][i]=0;
                Q.push({d[i],i});
            }
        }
    }
    for(int i=1;i<=n;i++){
        if(i==u) continue;
        else {
            cout << d[i] << " " << e[i] << endl;
        }
    }
}
main(){
    int t; cin>>t;
    while(t--){
        memset(a,0,sizeof(a));
        cin>>n>>m>>s;
        for(int i=1;i<=m;i++){
            int x,y,z; cin>>x>>y>>z;
            a[x][y]=z;
            a[y][x]=z;
        }
        DIJIK(s);
        cout << endl;
    }
}