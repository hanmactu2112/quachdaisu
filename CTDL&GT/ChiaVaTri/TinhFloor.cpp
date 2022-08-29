#include <bits/stdc++.h>
using namespace std;

long long timkiem(long long a[],long long x, long long l, long long r,long long k){
	
	if(l>r) {
		if(k>0) return k;
		return -1;
	}
	long long m = (l+r)/2;
	if(a[m]==x) return m;
	else if(a[m]<x) {
		k=max(k,m);
		return timkiem(a,x,m+1,r,k);
	}
	else {
		
		return timkiem(a,x,l,m-1,k);
	}
}

main(){
	int t;
	cin>>t;
	while(t--){
		long long n,x,k;
		k=0;
		cin>>n>>x;
		long long a[n+1];
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		cout<<timkiem(a,x,1,n,k)<<endl;
	}
}
