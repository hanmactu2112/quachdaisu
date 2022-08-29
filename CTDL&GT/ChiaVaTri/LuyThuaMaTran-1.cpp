#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9+7;
long long n,k;
struct matran{
	long long f[15][15];
};

matran operator*(matran a, matran b){
	matran c;
	for (int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			c.f[i][j]=0;
			for(int k=1;k<=n;k++){
				c.f[i][j] =( c.f[i][j]+(a.f[i][k]*b.f[k][j])%mod)%mod;
			}
		}
	}
	return c;
}
matran luythua(matran a, long long k){
	if(k==1) return a;
	matran x = luythua(a,k/2);
	if(k%2==0) return x*x;
	else return a*x*x;
}
main(){
	int t;
	cin>>t;
	while(t--){
		cin>>n>>k;
		matran a;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				cin>>a.f[i][j];
			}
		}
		matran kq = luythua(a,k);
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				cout<<kq.f[i][j]<<" ";
			}
			cout <<endl;
		}
		cout <<endl;
	}
}
