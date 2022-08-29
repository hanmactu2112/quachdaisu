#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9+7;
struct matran{
	long long f[2][2];	
};
matran operator*(matran a, matran b){
	matran c;
	for(int i=0;i<2;i++){
		for(int j=0;j<2;j++){
			c.f[i][j]=0;
			for(int k=0;k<2;k++){
				c.f[i][j] = (c.f[i][j]+ (a.f[i][k]*b.f[k][j])%mod)%mod;
			}
		}
	}
	return c;
}
matran luythua(matran a, long long n){
	if(n==1) return a; 
	matran c = luythua(a,n/2);
	if(n%2==0) return c*c;
	else return a*c*c;
}

main(){
	int t;
	cin>>t;
	while(t--){
		long long n;
		matran a;
		a.f[0][0]=1;a.f[0][1]=1;a.f[1][0]=1;a.f[1][1]=0;
		cin>>n;
		matran kq = luythua(a,n);
		cout<<kq.f[1][0]<<endl;
	}
}
