#include<bits/stdc++.h>
using namespace std;
long long mod=1e9+7;
struct matrix{
    long long f[3][3];
};
matrix operator*(matrix a, matrix b){
    matrix c;
    int i,j,k;
    for(i=1;i<=2;i++){
        for(int j=1;j<=2;j++){
            c.f[i][j]=0;
            for(k=1;k<=2;k++){
                c.f[i][j] =(c.f[i][j]+a.f[i][k]*b.f[k][j]%mod)%mod;
            }
        }
    }
    return c;
}
matrix pow(matrix a, long long m){
    if(m==1) return a;
    matrix x = pow(a,m/2);
    if(m%2==0) return  x*x;
    else return a*x*x;
}
main(){
    int t; cin>>t;
    while(t--){
        long long n;
        cin>>n;
        matrix a;
        a.f[1][1]=1; a.f[1][2]=1; a.f[2][1]=1; a.f[2][2]=0;
        matrix c = pow(a,n);
        cout << c.f[2][1] << endl;
    }
}