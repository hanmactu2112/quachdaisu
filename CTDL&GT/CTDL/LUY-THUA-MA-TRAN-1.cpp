#include<bits/stdc++.h>
using namespace std;
struct Matran{
    long long  f[15][15];
};
long long MOD=1e9+7;
int n; long long m;
Matran operator*(Matran A, Matran B){
    Matran C; int i,j,k;
    for(i=0;i<n;i++){
        for(j=0;j<n;j++){
            C.f[i][j]=0;
            for(k=0;k<n;k++){
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
    int t;
    cin>>t;
    while(t--){
        cin>>n>>m;
        Matran A;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin >> A.f[i][j];
            }
        }
        Matran KQ=powMod(A,m);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cout << KQ.f[i][j] << " ";
            }
            cout << endl;
        }
    }
}
