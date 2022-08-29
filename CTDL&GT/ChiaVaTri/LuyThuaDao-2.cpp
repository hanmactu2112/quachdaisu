#include <bits/stdc++.h>
using namespace std;
long long mod = 1e9+7;
long long power(long long n,long long r){
	if(r==0) return 1;
	if(r%2==0) return ((power(n,r/2)%mod)*(power(n,r/2)%mod))%mod;
	return ((n*(power(n,r-1))%mod)%mod);
}

long long dao(long long n){
	long long sum=0;
	while(n>0){
		sum = sum*10+n%10;
		n=n/10;
	}
	return sum;
}
main(){
	int t;
	cin>>t;
	while(t--){
		long long n;
		cin>>n;
		long long r = dao(n);
		cout<<power(n,r)<<endl;
	}
}
