#include<bits/stdc++.h>
using namespace std;
int A[1000+5][1000+5], C[1000+5][1000+5], n, m;
void xuly(){
    memset(C,0,sizeof(C));
    int i,j;
    C[1][1]=A[1][1];
    for(i=2;i<=m;i++) C[1][i]=C[1][i-1]+A[1][i];
    for(i=2;i<=n;i++) C[i][1]=C[i-1][1]+A[i][1];
    for(i=2;i<=n;i++){
        for(j=2;j<=m;j++){
            C[i][j]=A[i][j]+min(C[i-1][j],min(C[i-1][j-1],C[i][j-1]));
        }
    }
    cout << C[n][m] << endl;
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>m;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                cin>>A[i][j];
            }
        }
        xuly();
    }
}
// 3 3
// 1 2 3
// 4 8 2
// 1 5 3
// để đi được đến (2,2) thì có 3 cách đi từ (1,2) xuống, (1,1) chéo, (2,1) sang
// với hàng đầu và cột đầu thì chỉ có cách đi là từ trên xuống(ứng với cột ) hoặc trái sang(hàng)