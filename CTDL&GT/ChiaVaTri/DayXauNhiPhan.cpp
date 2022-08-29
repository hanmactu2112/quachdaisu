#include <bits/stdc++.h>
using namespace std;
	long long f[100];
long long xuly(long long n, long long m){
	if(n==1) return 0;
	if(n==2) return 1;
	if(m<=f[n-2]) return xuly(n-2,m);
	else return xuly(n-1,m-f[n-2]);
}

main(){

	f[1] =1;
	f[2] = 1;
	for(int i=3;i<=93;i++){
		f[i] = f[i-2]+f[i-1];
	}
	int t;
	cin>>t;
	while(t--){
		long long n,k;
		cin>>n>>k;
		cout<<xuly(n,k)<<endl;
	}
	
}
