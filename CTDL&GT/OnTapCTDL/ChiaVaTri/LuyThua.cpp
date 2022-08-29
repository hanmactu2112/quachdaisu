#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9+7;
long long luythua(long long a,long long n){
	if(n==0) return 1;
	long long x = luythua(a,n/2)%mod;
	if(n%2==0) return (x*x)%mod;
	else return a*luythua(a,n-1)%mod;
}

main(){
	long long t,a,n;
	cin>>t;
	while(t--){
		cin>>a>>n;
		cout<<luythua(a,n)<<endl;
	}
}
