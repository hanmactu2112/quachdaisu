#include<bits/stdc++.h>
using namespace std;
int A[505][505];
int n,m,t;
void xuly(){
    for(int k=1;k<=n;k++){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(A[i][j]>A[i][k]+A[k][j]){
                    A[i][j]=A[i][k]+A[k][j];
                }
            }
        }
    }
}
main(){
    cin>>n>>m;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            if(i==j) A[i][j]=0;
            else A[i][j]=1e9;
        }
    }
    for(int i=1;i<=m;i++){
        int x,y,z;
        cin>>x>>y>>z;
        A[x][y]=A[y][x]=z;
    }
    xuly();
    cin>>t;
    while(t--){
        int u,v;
        cin>>u>>v;
        cout << A[u][v] << endl;
    }
}
