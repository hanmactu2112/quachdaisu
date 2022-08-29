#include<bits/stdc++.h>
using namespace std;

int s[47],f[47],dem;

int xuly(int n,int k){
	if(n==0) {
		return dem;
	}
	if(n==1&&k==0) {
		dem=dem;
		return dem;
	}
	if(n==1) {
		dem=dem+1;
		return dem;
	}
	if(k<=f[n-1]) xuly(n-1,k);
	else if(k>f[n-1]){
		dem=dem+s[n-1];
		xuly(n-2,k-f[n-1]);
	}
	return dem;
}

main(){
	f[0]=1;f[1]=1;f[2]=2;
	s[0]=0;s[1]=1;s[2]=1;
	for(int i=3;i<47;i++){
		f[i]=f[i-1]+f[i-2];
		s[i]=s[i-1]+s[i-2];
	}
	int t,n,k;
	cin>>t;
	while(t--){
		cin>>n>>k;
		dem=0;
		cout<<xuly(n,k)<<endl;
	}
}
