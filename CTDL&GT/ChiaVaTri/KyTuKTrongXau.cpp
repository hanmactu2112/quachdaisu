#include <bits/stdc++.h>
using namespace std;

long long xuly(long long n, long long k){
	long long x = pow(2,n-1);
	if(k==x) return n;
	else if(k<x) return xuly(n-1,k);
	else return xuly(n-1,k-x);
}
main(){
	int t;
	cin>>t;
	char kt[25];
	kt[1]='A';
	for(int i=2;i<=25;i++){
		kt[i] = kt[i-1]+1;
	}
	while(t--){
		long long n,k;
		cin>>n>>k;
		int v=xuly(n,k);
		cout<<kt[v]<<endl;
	}

}
