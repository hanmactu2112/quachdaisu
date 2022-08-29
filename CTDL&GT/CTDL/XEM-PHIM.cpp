#include<bits/stdc++.h>
using namespace std;
int A[105],F[105][25005],n,m;
void xuly(){
    memset(F,0,sizeof(F));
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            F[i][j]=F[i-1][j];
            if(j>=A[i]){
                F[i][j]=max(F[i][j], F[i-1][j-A[i]]+A[i]);
            }
        }
    }
    cout << F[m][n] << endl;
}
main(){
    cin>>n>>m;
    for(int i=1;i<=m;i++) cin>>A[i];
    xuly();
}
