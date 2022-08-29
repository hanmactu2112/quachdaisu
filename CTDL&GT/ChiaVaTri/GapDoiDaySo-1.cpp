#include <bits/stdc++.h>
using namespace std;

long long xuly(long long n,long long k){
	long long x = pow(2,n-1);
	if(k==x) return n;
	else if(k<x) return xuly(n-1,k);
	else return xuly(n-1,k-x);
}

main(){
	int t;
	cin>>t;
	while(t--){
		long long n,k;
		cin>>n>>k;
		cout<<xuly(n,k)<<endl;
	}
}
