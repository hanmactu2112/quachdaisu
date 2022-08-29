#include<bits/stdc++.h>
using namespace std;
long long mod=1e9+7;
int n; long long m;
struct Matran{
    long long f[20][20];
};
Matran operator*(Matran A, Matran B){
    Matran C;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            C.f[i][j]=0;
            for(int k=0;k<n;k++){
                C.f[i][j] =(C.f[i][j]+A.f[i][k]*B.f[k][j]%mod)%mod;
            }
        }
    }
    return C;
}
Matran xuly(Matran A, long long k){
    if(k==1) return A;
    Matran X=xuly(A,k/2);
    if(k%2==0) return X*X;
    else return A*X*X;
}
main(){
    int t; cin>>t;
    while(t--){
        Matran A;
        cin>>n>>m;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cin>>A.f[i][j];
            }
        }
        Matran KQ=xuly(A,m);
        long long sum=0;
        for(int i=0;i<n;i++){
            sum = (sum + KQ.f[i][n-1])%mod;
        }
        cout << sum << endl;
    }
}
