#include<bits/stdc++.h>
using namespace std;
int A[505][505], C[505][505], n,m;
int xl(){
    memset(C,0,sizeof(C));
    int i,j,kq=0;
    for(i=1;i<=m;i++) C[0][i]=A[0][i];
    for(i=1;i<=n;i++) C[i][0]=A[i][0];
    for(i=1;i<=n;i++){
        for(j=1;j<=m;j++){
            if(A[i][j]==1){
                C[i][j]=min(C[i-1][j], min(C[i][j-1],C[i-1][j-1]))+1;
            } else {
                C[i][j]=0;
            }
            kq=max(kq,C[i][j]);
        }
    }
    return kq;
}
main(){
    int t,i,j;
    cin>>t;
    while(t--){
        cin>>n>>m;
        for(i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                cin>>A[i][j];
            }
        }
        cout << xl() << endl;
    }
}
/*
6 5
0 1 1 0 1
1 1 0 1 0
0 1 1 1 0
1 1 1 1 0
1 1 1 1 1
0 0 0 0 0
để nó là hình vuông thì tại a(i,j) phải bằng 1 và a[i-1][j]= và a[i][j-1]=1 và a[i-1][j-1]=1
vd:
1 1
0 1 thì a[2][2] =min(a[i-1][j],a[i][j-1],a[i-1][j-1])+1
*/