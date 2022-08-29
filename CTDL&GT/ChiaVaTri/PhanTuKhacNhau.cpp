#include <bits/stdc++.h>
using namespace std;

long long timkiem(long long a[], long long b[], long long l,long long r, long long k){
	if(l>r) return k;
	long long m = (l+r)/2;
	if(a[m]==b[m]) {
		return timkiem(a,b,m+1,r,k);
	}
	else {
		k= min(k,m);
		return timkiem(a,b,l,m-1,k);
	}
}
main(){
	int t;
	cin>>t;
	while(t--){
		long long n,k;
		k=1e18;
		cin>>n;
		long long a[n+1],b[n+1];
		for(int i=1;i<=n;i++){
			cin>>a[i];
		}
		for(int i=1;i<n;i++){
			cin>>b[i];
		}
		cout<<timkiem(a,b,1,n,k)<<endl;
	}
}

