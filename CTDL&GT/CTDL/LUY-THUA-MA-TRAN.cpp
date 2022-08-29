#include<bits/stdc++.h>
using namespace std;
long long MOD=1e9+7;
long long n,k;
struct matrix{
    long long f[15][15];
};
matrix operator*(matrix a, matrix b){
    matrix c;
    int i,j,k;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n;j++){
            c.f[i][j]=0;
            for(int k=1;k<=n;k++){
                c.f[i][j] = (c.f[i][j] + a.f[i][k] * b.f[k][j]%MOD)%MOD;
            }
        }
    }
    return c;
}
matrix pow(matrix a, long long m){
    if(m==1) return a;
    matrix x=pow(a,m/2);
    if(m%2==0) return x*x;
    else return a*x*x;
}
main(){
    int t; cin>>t;
    while(t--){
        cin>>n>>k;
        matrix a;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                cin>>a.f[i][j];
            }
        }
        matrix c=pow(a,k);
        long long sum=0;
        for(int i=1;i<=n;i++){
            sum = sum + c.f[i][n+1-i]%MOD;
            sum = sum % MOD;
        }
        cout << sum << endl; 
    }
}
// a[1][3] + a[2][2] + a[3][1];