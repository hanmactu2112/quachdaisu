#include <bits/stdc++.h>
using namespace std;
long long mod=1e9+7;
int n;
struct matran{
	long long f[11][11];
};

matran operator*(matran a, matran b){
	matran c;
	for(int i=1;i<=n;i++){
		for(int j=1;j<=n;j++){
			c.f[i][j] = 0;
			for(int k=1;k<=n;k++){
				c.f[i][j] = (c.f[i][j]+ (a.f[i][k]*b.f[k][j])%mod)%mod;
			}
		}
	}
	return c;
}
matran luythua (matran a ,long long k){
	if(k==1) return a;
	matran x = luythua(a,k/2);
	if(k%2==0) return x*x;
	else return a*x*x;
}
long long tinhtong(matran kq){
	long long sum=0;
		for(int i=1;i<=n;i++){
			sum = (sum+kq.f[i][n])%mod;
		}
	return sum;
}
main(){
	int t;
	cin>>t;
	while(t--){
		long long k;
		cin>>n>>k;
		matran a;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n;j++){
				cin>>a.f[i][j];
			}
		}
		matran kq = luythua(a,k);
		cout<<tinhtong(kq)<<endl;
	}
}
