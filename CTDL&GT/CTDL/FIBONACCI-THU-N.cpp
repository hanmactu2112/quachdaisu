#include<bits/stdc++.h>
using namespace std;
struct Matran{
    long long  f[2][2];
};
long long MOD=1e9+7;
Matran operator*(Matran A, Matran B){
    Matran C; int i,j,k;
    for(int i=0;i<2;i++){
        for(int j=0;j<2;j++){
            C.f[i][j]=0;
            for(int k=0;k<2;k++){
                C.f[i][j] = (C.f[i][j]+ A.f[i][k]*B.f[k][j]%MOD) %MOD;
            }
        }
    }
    return C;
}
Matran powMod(Matran A, int n){
    if(n==1) return A;
    Matran X=powMod(A,n/2);
    if(n%2==0) return X*X;
    else return A*X*X;
}
main(){
    int t, n ;
    cin>>t;
    while(t--){
        cin>>n;
        Matran A; A.f[0][0]=1; A.f[0][1]=1; A.f[1][0]=1; A.f[1][1]=0;
        Matran KQ=powMod(A,n);
        cout << KQ.f[1][0] << endl;
    }
}
